package top.metass.pro.module.system.convert.tenant;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.system.controller.admin.permission.vo.role.RoleSimpleRespVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.packages.TenantPackageCreateReqVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.packages.TenantPackageRespVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.packages.TenantPackageSimpleRespVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.packages.TenantPackageUpdateReqVO;
import top.metass.pro.module.system.dal.dataobject.tenant.TenantPackageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户套餐 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface TenantPackageConvert {

    TenantPackageConvert INSTANCE = Mappers.getMapper(TenantPackageConvert.class);

    TenantPackageDO convert(TenantPackageCreateReqVO bean);

    TenantPackageDO convert(TenantPackageUpdateReqVO bean);

    TenantPackageRespVO convert(TenantPackageDO bean);

    List<TenantPackageRespVO> convertList(List<TenantPackageDO> list);

    PageResult<TenantPackageRespVO> convertPage(PageResult<TenantPackageDO> page);

    List<TenantPackageSimpleRespVO> convertList02(List<TenantPackageDO> list);

}
