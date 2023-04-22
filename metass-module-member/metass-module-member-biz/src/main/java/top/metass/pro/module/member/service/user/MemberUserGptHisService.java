package top.metass.pro.module.member.service.user;

import java.util.*;
import javax.validation.*;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptHisDO;
import top.metass.pro.framework.common.pojo.PageResult;

/**
 * 会员gpt扩展历史 Service 接口
 *
 * @author 三生
 */
public interface MemberUserGptHisService {

    /**
     * 创建会员gpt扩展历史
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserGptHis(@Valid MemberUserGptHisCreateReqVO createReqVO);

    /**
     * 更新会员gpt扩展历史
     *
     * @param updateReqVO 更新信息
     */
    void updateUserGptHis(@Valid MemberUserGptHisUpdateReqVO updateReqVO);

    /**
     * 删除会员gpt扩展历史
     *
     * @param id 编号
     */
    void deleteUserGptHis(Long id);

    /**
     * 获得会员gpt扩展历史
     *
     * @param id 编号
     * @return 会员gpt扩展历史
     */
    MemberUserGptHisDO getUserGptHis(Long id);

    /**
     * 获得会员gpt扩展历史列表
     *
     * @param ids 编号
     * @return 会员gpt扩展历史列表
     */
    List<MemberUserGptHisDO> getUserGptHisList(Collection<Long> ids);

    /**
     * 获得会员gpt扩展历史分页
     *
     * @param pageReqVO 分页查询
     * @return 会员gpt扩展历史分页
     */
    PageResult<MemberUserGptHisDO> getUserGptHisPage(MemberUserGptHisPageReqVO pageReqVO);

    /**
     * 获得会员gpt扩展历史列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员gpt扩展历史列表
     */
    List<MemberUserGptHisDO> getUserGptHisList(MemberUserGptHisExportReqVO exportReqVO);

}
