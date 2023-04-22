package top.metass.pro.module.member.service.user;

import java.util.*;
import javax.validation.*;

import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.controller.app.user.vo.AppMemberUserGptRespVO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import top.metass.pro.framework.common.pojo.PageResult;

/**
 * 会员gpt扩展 Service 接口
 *
 * @author 三生
 */
public interface MemberUserGptService {

    /**
     * 创建会员gpt扩展
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserGpt(@Valid MemberUserGptCreateReqVO createReqVO);

    /**
     * 更新会员gpt扩展
     *
     * @param updateReqVO 更新信息
     */
    void updateUserGpt(@Valid MemberUserGptUpdateReqVO updateReqVO);

    /**
     * 删除会员gpt扩展
     *
     * @param id 编号
     */
    void deleteUserGpt(Long id);

    /**
     * 获得会员gpt扩展
     *
     * @param id 编号
     * @return 会员gpt扩展
     */
    MemberUserGptDO getUserGpt(Long id);

    /**
     * 获得会员gpt
     *
     * @param userId 用户ID
     * @return 会员gpt扩展
     */
    MemberUserGptDO getUserGptByUserId(Long userId);

    /**
     * 获得会员gpt扩展列表
     *
     * @param ids 编号
     * @return 会员gpt扩展列表
     */
    List<MemberUserGptDO> getUserGptList(Collection<Long> ids);

    /**
     * 获得会员gpt扩展分页
     *
     * @param pageReqVO 分页查询
     * @return 会员gpt扩展分页
     */
    PageResult<MemberUserGptDO> getUserGptPage(MemberUserGptPageReqVO pageReqVO);

    /**
     * 获得会员gpt扩展列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员gpt扩展列表
     */
    List<MemberUserGptDO> getUserGptList(MemberUserGptExportReqVO exportReqVO);

    MemberUserGptDO getChatInfo(Long userId);

    MemberUserGptDO checkChatInfo(Long userId);

}
