package top.metass.pro.module.member.service.user;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import top.metass.pro.framework.common.enums.CommonStatusEnum;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.infra.api.file.FileApi;
import top.metass.pro.module.member.api.spu.MemberSpuApi;
import top.metass.pro.module.member.api.spu.MemberSpuApiImpl;
import top.metass.pro.module.member.api.spu.dto.MemberSpuRespDTO;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserCreateReqVO;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserExportReqVO;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserPageReqVO;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserUpdateReqVO;
import top.metass.pro.module.member.controller.app.user.vo.AppUserUpdateMobileReqVO;
import top.metass.pro.module.member.convert.user.MemberUserConvert;
import top.metass.pro.module.member.convert.user.MemberUserGptConvert;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import top.metass.pro.module.member.dal.mysql.user.MemberUserMapper;
import top.metass.pro.module.member.service.spu.SpuService;
import top.metass.pro.module.system.api.sms.SmsCodeApi;
import top.metass.pro.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import top.metass.pro.module.system.enums.sms.SmsSceneEnum;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.InputStream;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.framework.common.util.date.LocalDateTimeUtils.addTime;
import static top.metass.pro.framework.common.util.servlet.ServletUtils.getClientIP;
import static top.metass.pro.module.member.enums.ErrorCodeConstants.USER_NOT_EXISTS;

/**
 * 会员 User Service 实现类
 *
 * @author 三生宇宙
 */
@Service
@Valid
@Slf4j
public class MemberUserServiceImpl implements MemberUserService {

    @Resource
    private MemberUserMapper memberUserMapper;

    @Resource
    private FileApi fileApi;
    @Resource
    private SmsCodeApi smsCodeApi;

    @Resource
    private PasswordEncoder passwordEncoder;


    @Resource
    private SpuService spuService;

    @Resource
    @Lazy
    private MemberUserGptService userGptService;

    @Override
    public MemberUserDO getUserByMobile(String mobile) {
        return memberUserMapper.selectByMobile(mobile);
    }

    @Override
    public List<MemberUserDO> getUserListByNickname(String nickname) {
        return memberUserMapper.selectListByNicknameLike(nickname);
    }

    @Override
    public MemberUserDO createUserIfAbsent(String mobile, String registerIp) {
        // 用户已经存在
        MemberUserDO user = memberUserMapper.selectByMobile(mobile);
        if (user != null) {
            return user;
        }
        // 用户不存在，则进行创建
        return this.createUser(mobile, registerIp);
    }

    private MemberUserDO createUser(String mobile, String registerIp) {
        // 生成密码
        String password = IdUtil.fastSimpleUUID();
        // 插入用户
        MemberUserDO user = new MemberUserDO();
        user.setMobile(mobile);
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(encodePassword(password)); // 加密密码
        user.setRegisterIp(registerIp);
        memberUserMapper.insert(user);
        return user;
    }

    @Override
    public void updateUserLogin(Long id, String loginIp) {
        memberUserMapper.updateById(new MemberUserDO().setId(id)
                .setLoginIp(loginIp).setLoginDate(LocalDateTime.now()));
    }

    @Override
    public MemberUserDO getUser(Long id) {
        return memberUserMapper.selectById(id);
    }

    @Override
    public List<MemberUserDO> getUserList(Collection<Long> ids) {
        return memberUserMapper.selectBatchIds(ids);
    }

    @Override
    public void updateUserNickname(Long userId, String nickname) {
        MemberUserDO user = this.checkUserExists(userId);
        // 仅当新昵称不等于旧昵称时进行修改
        if (nickname.equals(user.getNickname())){
            return;
        }
        MemberUserDO userDO = new MemberUserDO();
        userDO.setId(user.getId());
        userDO.setNickname(nickname);
        memberUserMapper.updateById(userDO);
    }

    @Override
    public String updateUserAvatar(Long userId, InputStream avatarFile) throws Exception {
        this.checkUserExists(userId);
        // 创建文件
        String avatar = fileApi.createFile(IoUtil.readBytes(avatarFile));
        // 更新头像路径
        memberUserMapper.updateById(MemberUserDO.builder().id(userId).avatar(avatar).build());
        return avatar;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserMobile(Long userId, AppUserUpdateMobileReqVO reqVO) {
        // 检测用户是否存在
        checkUserExists(userId);
        // TODO 三生：oldMobile 应该不用传递

        // 校验旧手机和旧验证码
        smsCodeApi.useSmsCode(new SmsCodeUseReqDTO().setMobile(reqVO.getOldMobile()).setCode(reqVO.getOldCode())
                .setScene(SmsSceneEnum.MEMBER_UPDATE_MOBILE.getScene()).setUsedIp(getClientIP()));
        // 使用新验证码
        smsCodeApi.useSmsCode(new SmsCodeUseReqDTO().setMobile(reqVO.getMobile()).setCode(reqVO.getCode())
                .setScene(SmsSceneEnum.MEMBER_UPDATE_MOBILE.getScene()).setUsedIp(getClientIP()));

        // 更新用户手机
        memberUserMapper.updateById(MemberUserDO.builder().id(userId).mobile(reqVO.getMobile()).build());
    }

    @Override
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @VisibleForTesting
    public MemberUserDO checkUserExists(Long id) {
        if (id == null) {
            return null;
        }
        MemberUserDO user = memberUserMapper.selectById(id);
        if (user == null) {
            throw exception(USER_NOT_EXISTS);
        }
        return user;
    }

    @Override
    public Long createUser(MemberUserCreateReqVO createReqVO) {
        // 插入
        MemberUserDO user = MemberUserConvert.INSTANCE.convert(createReqVO);
        memberUserMapper.insert(user);
        // 返回
        return user.getId();
    }

    @Override
    public void updateUser(MemberUserUpdateReqVO updateReqVO) {
        // 校验存在
        validateUserExists(updateReqVO.getId());
        // 更新
        MemberUserDO updateObj = MemberUserConvert.INSTANCE.convert(updateReqVO);
        memberUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteUser(Long id) {
        // 校验存在
        validateUserExists(id);
        // 删除
        memberUserMapper.deleteById(id);
    }

    private void validateUserExists(Long id) {
        if (memberUserMapper.selectById(id) == null) {
            throw exception(USER_NOT_EXISTS);
        }
    }

    @Override
    public PageResult<MemberUserDO> getUserPage(MemberUserPageReqVO pageReqVO) {
        return memberUserMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserDO> getUserList(MemberUserExportReqVO exportReqVO) {
        return memberUserMapper.selectList(exportReqVO);
    }

    @Override
    public boolean updateUserSpu(Long userId,Long spuId) {
        // 校验存在
        SpuDO spu = spuService.getSpu(spuId);
        if (spu == null) {
            log.debug("商品不存在ID为：{}",spuId);
            return false;
        }
        MemberUserDO user = getUser(userId);
        if (user == null) {
            log.debug("用户不存在:{}",userId);
            return false;
        }
        MemberUserGptDO userGpt = userGptService.getUserGptByUserId(userId);
        if (userGpt == null) {
            log.debug("用户不存在:{}",userId);
            return false;
        }

        if (StrUtil.equals(spu.getType(),"30")) {//次数卡
            Long integral = Long.parseLong(userGpt.getIntegral())+Long.parseLong(spu.getParm1());
            userGpt.setIntegral(StrUtil.toString(integral));
        }else {
            userGpt.setVipType(spu.getType());
            LocalDateTime vipExpires = userGpt.getVipExpires();
            LocalDateTime currentTime = LocalDateTime.now();

            // 判断是否在过期时间基础上增加天数
            if (vipExpires != null && vipExpires.isAfter(currentTime)) {
                userGpt.setVipExpires(vipExpires.plusDays(Long.parseLong(spu.getParm1())));
            } else {
                userGpt.setVipExpires(addTime(Duration.ofDays(Long.parseLong(spu.getParm1()))));
            }
        }

        userGptService.updateUserGpt(MemberUserGptConvert.INSTANCE.convert3(userGpt));


        return true;
    }
}
