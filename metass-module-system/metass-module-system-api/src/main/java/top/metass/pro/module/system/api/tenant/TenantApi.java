package top.metass.pro.module.system.api.tenant;

import top.metass.pro.module.system.api.tenant.dot.TenantBaseDTO;

import java.util.List;

/**
 * 多租户的 API 接口
 *
 * @author 三生宇宙
 */
public interface TenantApi {

    /**
     * 获得所有租户
     *
     * @return 租户编号数组
     */
    List<Long> getTenantIdList();

    /**
     * 校验租户是否合法
     *
     * @param id 租户编号
     */
    void validateTenant(Long id);

    /**
     * 获得租户信息
     *
     * @return 租户编号数组
     */
    TenantBaseDTO getTenantInfo(Long id);

}
