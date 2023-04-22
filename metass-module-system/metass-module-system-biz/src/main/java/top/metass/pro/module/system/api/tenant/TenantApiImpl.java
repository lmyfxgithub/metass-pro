package top.metass.pro.module.system.api.tenant;

import top.metass.pro.module.system.api.tenant.dot.TenantBaseDTO;
import top.metass.pro.module.system.convert.tenant.TenantConvert;
import top.metass.pro.module.system.dal.dataobject.tenant.TenantDO;
import top.metass.pro.module.system.service.tenant.TenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 多租户的 API 实现类
 *
 * @author 三生宇宙
 */
@Service
public class TenantApiImpl implements TenantApi {

    @Resource
    private TenantService tenantService;

    @Override
    public List<Long> getTenantIdList() {
        return tenantService.getTenantIdList();
    }

    @Override
    public void validateTenant(Long id) {
        tenantService.validTenant(id);
    }

    @Override
    public TenantBaseDTO getTenantInfo(Long id) {
        return TenantConvert.INSTANCE.convert2(tenantService.getTenant(id));
    }


}
