package top.metass.pro.module.infra.dal.mysql.db;

import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author 三生宇宙
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
