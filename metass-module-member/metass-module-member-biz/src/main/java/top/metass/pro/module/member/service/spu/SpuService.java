package top.metass.pro.module.member.service.spu;

import java.util.*;
import javax.validation.*;
import top.metass.pro.module.member.controller.admin.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import top.metass.pro.framework.common.pojo.PageResult;

/**
 * 会员商品 Service 接口
 *
 * @author 三生
 */
public interface SpuService {

    /**
     * 创建会员商品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSpu(@Valid SpuCreateReqVO createReqVO);

    /**
     * 更新会员商品
     *
     * @param updateReqVO 更新信息
     */
    void updateSpu(@Valid SpuUpdateReqVO updateReqVO);

    /**
     * 删除会员商品
     *
     * @param id 编号
     */
    void deleteSpu(Long id);

    /**
     * 获得会员商品
     *
     * @param id 编号
     * @return 会员商品
     */
    SpuDO getSpu(Long id);

    /**
     * 获得会员商品列表
     *
     * @param ids 编号
     * @return 会员商品列表
     */
    List<SpuDO> getSpuList(Collection<Long> ids);

    /**
     * 获得会员商品分页
     *
     * @param pageReqVO 分页查询
     * @return 会员商品分页
     */
    PageResult<SpuDO> getSpuPage(SpuPageReqVO pageReqVO);

    /**
     * 获得会员商品列表
     *
     * @param exportReqVO 查询条件
     * @return 会员商品列表
     */
    List<SpuDO> getSpuList(SpuExportReqVO exportReqVO);

    /**
     * 获得会员商品列表
     *
     * @param supVO 查询条件
     * @return 会员商品列表
     */
    List<SpuDO> getDoSpuList(SpuDO supVO);

}
