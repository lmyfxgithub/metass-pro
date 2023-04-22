package top.metass.pro.module.system.api.tenant.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiangdi
 * @version 2023/4/14 12:47 top.metass.pro.module.system.api.tenant.dot.TenantBaseDTO.java V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantBaseDTO {

    private String id;
    private String name;
    private String domain;
    private String contactName;
    private String contactMobile;
    private Integer status;
}
