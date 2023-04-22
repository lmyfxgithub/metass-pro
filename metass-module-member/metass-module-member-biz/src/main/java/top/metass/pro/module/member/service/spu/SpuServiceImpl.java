package top.metass.pro.module.member.service.spu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import top.metass.pro.module.member.controller.admin.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.member.convert.spu.SpuConvert;
import top.metass.pro.module.member.dal.mysql.spu.SpuMapper;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.module.member.enums.ErrorCodeConstants.*;
import static top.metass.pro.module.system.enums.ErrorCodeConstants.MEMBER_SPU_NOT_EXISTS;

/**
 * 会员商品 Service 实现类
 *
 * @author 三生
 */
@Service
@Validated
public class SpuServiceImpl implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Override
    public Long createSpu(SpuCreateReqVO createReqVO) {
        // 插入
        SpuDO spu = SpuConvert.INSTANCE.convert(createReqVO);
        spuMapper.insert(spu);
        // 返回
        return spu.getId();
    }

    @Override
    public void updateSpu(SpuUpdateReqVO updateReqVO) {
        // 校验存在
        validateSpuExists(updateReqVO.getId());
        // 更新
        SpuDO updateObj = SpuConvert.INSTANCE.convert(updateReqVO);
        spuMapper.updateById(updateObj);
    }

    @Override
    public void deleteSpu(Long id) {
        // 校验存在
        validateSpuExists(id);
        // 删除
        spuMapper.deleteById(id);
    }

    private void validateSpuExists(Long id) {
        if (spuMapper.selectById(id) == null) {
            throw exception(MEMBER_SPU_NOT_EXISTS);
        }
    }

    @Override
    public SpuDO getSpu(Long id) {
        return spuMapper.selectById(id);
    }

    @Override
    public List<SpuDO> getSpuList(Collection<Long> ids) {
        return spuMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpuDO> getSpuPage(SpuPageReqVO pageReqVO) {
        return spuMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpuDO> getSpuList(SpuExportReqVO exportReqVO) {
        return spuMapper.selectList(exportReqVO);
    }

    @Override
    public List<SpuDO> getDoSpuList(SpuDO supVO) {
        return spuMapper.selectList(supVO);
    }

}
