package top.metass.pro.module.system.convert.tenant;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.system.api.tenant.dot.TenantBaseDTO;
import top.metass.pro.module.system.controller.admin.tenant.vo.tenant.TenantCreateReqVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.tenant.TenantExcelVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.tenant.TenantRespVO;
import top.metass.pro.module.system.controller.admin.tenant.vo.tenant.TenantUpdateReqVO;
import top.metass.pro.module.system.controller.admin.user.vo.user.UserCreateReqVO;
import top.metass.pro.module.system.dal.dataobject.tenant.TenantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface TenantConvert {

    TenantConvert INSTANCE = Mappers.getMapper(TenantConvert.class);

    TenantDO convert(TenantCreateReqVO bean);

    TenantDO convert(TenantUpdateReqVO bean);

    TenantRespVO convert(TenantDO bean);
    TenantBaseDTO convert2(TenantDO bean);

    List<TenantRespVO> convertList(List<TenantDO> list);

    PageResult<TenantRespVO> convertPage(PageResult<TenantDO> page);

    List<TenantExcelVO> convertList02(List<TenantDO> list);

    default UserCreateReqVO convert02(TenantCreateReqVO bean) {
        UserCreateReqVO reqVO = new UserCreateReqVO();
        reqVO.setUsername(bean.getUsername());
        reqVO.setPassword(bean.getPassword());
        reqVO.setNickname(bean.getContactName()).setMobile(bean.getContactMobile());
        return reqVO;
    }

}
