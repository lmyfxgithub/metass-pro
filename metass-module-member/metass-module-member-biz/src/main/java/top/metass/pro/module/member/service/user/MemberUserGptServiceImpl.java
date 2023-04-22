package top.metass.pro.module.member.service.user;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import top.metass.pro.framework.security.core.LoginUser;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.system.api.dict.DictDataApi;
import top.metass.pro.module.system.api.dict.dto.DictDataRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.validation.constraints.AssertTrue;

import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.member.convert.user.MemberUserGptConvert;
import top.metass.pro.module.member.dal.mysql.user.MemberUserGptMapper;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.framework.security.core.util.SecurityFrameworkUtils.getLoginUser;
import static top.metass.pro.module.member.enums.ErrorCodeConstants.*;
import static top.metass.pro.module.system.enums.ErrorCodeConstants.MEMBER_USER_GPT_INSUFFICIENT_INTEGRAL;
import static top.metass.pro.module.system.enums.ErrorCodeConstants.MEMBER_USER_GPT_NOT_EXISTS;

/**
 * 会员gpt扩展 Service 实现类
 *
 * @author 三生
 */
@Service
@Validated
@Slf4j
public class MemberUserGptServiceImpl implements MemberUserGptService {

    @Resource
    private MemberUserGptMapper userGptMapper;

    @Resource
    private DictDataApi dictDataApi;

    @Resource
    private MemberUserService memberUserService;

    @Override
    public Long createUserGpt(MemberUserGptCreateReqVO createReqVO) {
        // 插入
        MemberUserGptDO userGpt = MemberUserGptConvert.INSTANCE.convert(createReqVO);
        userGptMapper.insert(userGpt);
        // 返回
        return userGpt.getId();
    }

    @Override
    public void updateUserGpt(MemberUserGptUpdateReqVO updateReqVO) {
        // 校验存在
        validateUserGptExistsByUserId(updateReqVO.getUserId());
        // 更新
        MemberUserGptDO updateObj = MemberUserGptConvert.INSTANCE.convert(updateReqVO);
        userGptMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserGpt(Long id) {
        // 校验存在
        validateUserGptExists(id);
        // 删除
        userGptMapper.deleteById(id);
    }

    private void validateUserGptExists(Long id) {
        if (userGptMapper.selectByUserId(id) == null) {
            throw exception(MEMBER_USER_GPT_NOT_EXISTS);
        }
    }

    private void validateUserGptExistsByUserId(Long userId) {
        if (userGptMapper.selectByUserId(userId) == null) {
            throw exception(MEMBER_USER_GPT_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserGptDO getUserGpt(Long id) {
        return userGptMapper.selectById(id);
    }

    @Override
    public MemberUserGptDO getUserGptByUserId(Long userId) {
        MemberUserGptExportReqVO memberUserGptExportReqVO = new MemberUserGptExportReqVO();
        memberUserGptExportReqVO.setUserId(userId);

        return userGptMapper.selectList(memberUserGptExportReqVO).stream().findFirst().orElse(null);
    }


    @Override
    public List<MemberUserGptDO> getUserGptList(Collection<Long> ids) {
        return userGptMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserGptDO> getUserGptPage(MemberUserGptPageReqVO pageReqVO) {
        return userGptMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserGptDO> getUserGptList(MemberUserGptExportReqVO exportReqVO) {
        return userGptMapper.selectList(exportReqVO);
    }

    @Override
    public MemberUserGptDO getChatInfo(Long userId) {
        MemberUserGptExportReqVO memberUserGptExportReqVO = new MemberUserGptExportReqVO();
        memberUserGptExportReqVO.setUserId(userId);
        MemberUserGptDO memberUserGptDO = userGptMapper.selectList(memberUserGptExportReqVO).stream().findFirst().orElse(null);

        if (memberUserGptDO == null) {
            DictDataRespDTO initBalance = dictDataApi.parseDictData("gpt_setting_info", "init_balance");
            String balanceValue = (ObjUtil.isEmpty(initBalance)||StrUtil.isBlankIfStr(initBalance.getValue()))
                    ?  "10": initBalance.getValue();

            log.debug("未获取到用户gpt扩展信息：{}", userId);
            log.debug("创建gpt扩展信息，赠送初始积分：{}", balanceValue);

            MemberUserDO user = memberUserService.getUser(userId);
            Assert.isTrue(ObjUtil.isNotNull(user),"未获取到对应用户信息");

            MemberUserGptCreateReqVO createReqVO = new MemberUserGptCreateReqVO();
            createReqVO.setUserId(userId);
            createReqVO.setIntegral(balanceValue);
            createReqVO.setMobile(user.getMobile());
            createReqVO.setVipType("0");
            createUserGpt(createReqVO);
            memberUserGptDO = getUserGpt(userId);
        }

        // 检查会员是否过期
        LocalDateTime now = LocalDateTime.now();
        if (memberUserGptDO.getVipExpires() != null && memberUserGptDO.getVipExpires().isBefore(now)) {
            // 如果会员已过期，将会员类型设置为非会员
            memberUserGptDO.setVipType("0");

            // 更新数据库中的会员类型
            MemberUserGptUpdateReqVO updateReqVO = new MemberUserGptUpdateReqVO();
            updateReqVO.setUserId(userId);
            updateReqVO.setVipType("0");
            updateUserGpt(updateReqVO);
        }

        return memberUserGptDO;
    }



    @Override
    public MemberUserGptDO checkChatInfo(Long userId) {
        MemberUserGptDO memberUserGptDO = getChatInfo(userId);
        int currentIntegral = Integer.parseInt(memberUserGptDO.getIntegral());
        int vipType = Integer.parseInt(memberUserGptDO.getVipType());
        LocalDateTime vipExpires = memberUserGptDO.getVipExpires();
        LocalDateTime now = LocalDateTime.now();

        if (vipType == 1) { // 高级会员
            if (vipExpires.isBefore(now)) { // 高级会员过期
                if (currentIntegral <= 0) {
                    throw exception(MEMBER_USER_GPT_INSUFFICIENT_INTEGRAL);
                } else {
                    memberUserGptDO.setIntegral(StrUtil.toString((currentIntegral - 1)));
                    userGptMapper.updateById(memberUserGptDO);
                    // TODO 记录在 his 表中的逻辑应该在这里实现
                }
            }
            // 如果高级会员未过期，则不执行任何操作
        } else { // 普通会员，会员类型为0
            if (currentIntegral <= 0) {
                throw exception(MEMBER_USER_GPT_INSUFFICIENT_INTEGRAL);
            }
            memberUserGptDO.setIntegral(StrUtil.toString((currentIntegral - 1)));
            userGptMapper.updateById(memberUserGptDO);
            // TODO 记录在 his 表中的逻辑应该在这里实现
        }

        return memberUserGptDO;
    }





}
