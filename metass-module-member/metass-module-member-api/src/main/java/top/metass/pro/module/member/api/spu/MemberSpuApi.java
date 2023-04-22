package top.metass.pro.module.member.api.spu;

import top.metass.pro.module.member.api.spu.dto.MemberSpuRespDTO;

import java.util.List;

/**
 * @author jiangdi
 * @version 2023/4/13 11:16 top.metass.pro.module.member.api.spu.MemberSpuApi.java V1.0
 */
public interface MemberSpuApi {

    /**
     * 获得会员用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    MemberSpuRespDTO getSpu(Long id);

    /**
     * 获得会员商品列表
     *
     * @param supVO 查询条件
     * @return 会员商品列表
     */
    List<MemberSpuRespDTO> getDoSpuList(MemberSpuRespDTO supVO);


}
