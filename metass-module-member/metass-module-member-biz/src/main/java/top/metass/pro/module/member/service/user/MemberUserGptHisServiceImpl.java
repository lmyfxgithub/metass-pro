package top.metass.pro.module.member.service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptHisDO;
import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.member.convert.user.MemberUserGptHisConvert;
import top.metass.pro.module.member.dal.mysql.user.MemberUserGptHisMapper;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.module.member.enums.ErrorCodeConstants.*;
import static top.metass.pro.module.system.enums.ErrorCodeConstants.MEMBER_USER_GPT_HIS_NOT_EXISTS;

/**
 * 会员gpt扩展历史 Service 实现类
 *
 * @author 三生
 */
@Service
@Validated
public class MemberUserGptHisServiceImpl implements MemberUserGptHisService {

    @Resource
    private MemberUserGptHisMapper userGptHisMapper;

    @Override
    public Long createUserGptHis(MemberUserGptHisCreateReqVO createReqVO) {
        // 插入
        MemberUserGptHisDO userGptHis = MemberUserGptHisConvert.INSTANCE.convert(createReqVO);
        userGptHisMapper.insert(userGptHis);
        // 返回
        return userGptHis.getId();
    }

    @Override
    public void updateUserGptHis(MemberUserGptHisUpdateReqVO updateReqVO) {
        // 校验存在
        validateUserGptHisExists(updateReqVO.getId());
        // 更新
        MemberUserGptHisDO updateObj = MemberUserGptHisConvert.INSTANCE.convert(updateReqVO);
        userGptHisMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserGptHis(Long id) {
        // 校验存在
        validateUserGptHisExists(id);
        // 删除
        userGptHisMapper.deleteById(id);
    }

    private void validateUserGptHisExists(Long id) {
        if (userGptHisMapper.selectById(id) == null) {
            throw exception(MEMBER_USER_GPT_HIS_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserGptHisDO getUserGptHis(Long id) {
        return userGptHisMapper.selectById(id);
    }

    @Override
    public List<MemberUserGptHisDO> getUserGptHisList(Collection<Long> ids) {
        return userGptHisMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserGptHisDO> getUserGptHisPage(MemberUserGptHisPageReqVO pageReqVO) {
        return userGptHisMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserGptHisDO> getUserGptHisList(MemberUserGptHisExportReqVO exportReqVO) {
        return userGptHisMapper.selectList(exportReqVO);
    }

}
