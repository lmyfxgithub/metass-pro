package top.metass.pro.module.product.service.sku;

import top.metass.pro.framework.common.enums.CommonStatusEnum;
import top.metass.pro.framework.test.core.ut.BaseDbUnitTest;
import top.metass.pro.framework.test.core.util.AssertUtils;
import top.metass.pro.module.product.api.sku.dto.ProductSkuUpdateStockReqDTO;
import top.metass.pro.module.product.controller.admin.sku.vo.ProductSkuCreateOrUpdateReqVO;
import top.metass.pro.module.product.dal.dataobject.sku.ProductSkuDO;
import top.metass.pro.module.product.dal.mysql.sku.ProductSkuMapper;
import top.metass.pro.module.product.service.property.ProductPropertyService;
import top.metass.pro.module.product.service.property.ProductPropertyValueService;
import top.metass.pro.module.product.service.spu.ProductSpuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static top.metass.pro.framework.test.core.util.AssertUtils.assertPojoEquals;
import static top.metass.pro.framework.test.core.util.AssertUtils.assertServiceException;
import static top.metass.pro.framework.test.core.util.RandomUtils.randomPojo;
import static top.metass.pro.module.product.enums.ErrorCodeConstants.SKU_NOT_EXISTS;
import static top.metass.pro.module.product.enums.ErrorCodeConstants.SKU_STOCK_NOT_ENOUGH;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

/**
 * {@link ProductSkuServiceImpl} 的单元测试
 *
 * @author 三生宇宙
 */
@Import(ProductSkuServiceImpl.class)
public class ProductSkuServiceTest extends BaseDbUnitTest {

    @Resource
    private ProductSkuService productSkuService;

    @Resource
    private ProductSkuMapper productSkuMapper;

    @MockBean
    private ProductSpuService productSpuService;
    @MockBean
    private ProductPropertyService productPropertyService;
    @MockBean
    private ProductPropertyValueService productPropertyValueService;

    @Test
    public void testUpdateSkuList() {
        // mock 数据
        ProductSkuDO sku01 = randomPojo(ProductSkuDO.class, o -> { // 测试更新
            o.setSpuId(1L);
            o.setProperties(singletonList(new ProductSkuDO.Property(10L, 20L)));
        });
        productSkuMapper.insert(sku01);
        ProductSkuDO sku02 = randomPojo(ProductSkuDO.class, o -> { // 测试删除
            o.setSpuId(1L);
            o.setProperties(singletonList(new ProductSkuDO.Property(10L, 30L)));
        });
        productSkuMapper.insert(sku02);
        // 准备参数
        Long spuId = 1L;
        String spuName = "测试商品";
        List<ProductSkuCreateOrUpdateReqVO> skus = Arrays.asList(
                randomPojo(ProductSkuCreateOrUpdateReqVO.class, o -> { // 测试更新
                    o.setProperties(singletonList(new ProductSkuCreateOrUpdateReqVO.Property(10L, 20L)));
                    o.setStatus(CommonStatusEnum.ENABLE.getStatus());
                }),
                randomPojo(ProductSkuCreateOrUpdateReqVO.class, o -> { // 测试新增
                    o.setProperties(singletonList(new ProductSkuCreateOrUpdateReqVO.Property(10L, 40L)));
                    o.setStatus(CommonStatusEnum.ENABLE.getStatus());
                })
        );

        // 调用
        productSkuService.updateSkuList(spuId, spuName, skus);
        // 断言
        List<ProductSkuDO> dbSkus = productSkuMapper.selectListBySpuId(spuId);
        assertEquals(dbSkus.size(), 2);
        // 断言更新的
        assertEquals(dbSkus.get(0).getId(), sku01.getId());
        assertPojoEquals(dbSkus.get(0), skus.get(0), "properties");
        assertEquals(skus.get(0).getProperties().size(), 1);
        assertPojoEquals(dbSkus.get(0).getProperties().get(0), skus.get(0).getProperties().get(0));
        // 断言新增的
        assertNotEquals(dbSkus.get(1).getId(), sku02.getId());
        assertPojoEquals(dbSkus.get(1), skus.get(1), "properties");
        assertEquals(skus.get(1).getProperties().size(), 1);
        assertPojoEquals(dbSkus.get(1).getProperties().get(0), skus.get(1).getProperties().get(0));
    }

    @Test
    public void testUpdateSkuStock_incrSuccess() {
        // 准备参数
        ProductSkuUpdateStockReqDTO updateStockReqDTO = new ProductSkuUpdateStockReqDTO()
                .setItems(singletonList(new ProductSkuUpdateStockReqDTO.Item().setId(1L).setIncrCount(10)));
        // mock 数据
        productSkuMapper.insert(randomPojo(ProductSkuDO.class, o -> o.setId(1L).setSpuId(10L).setStock(20)));

        // 调用
        productSkuService.updateSkuStock(updateStockReqDTO);
        // 断言
        ProductSkuDO sku = productSkuMapper.selectById(1L);
        assertEquals(sku.getStock(), 30);
        verify(productSpuService).updateSpuStock(argThat(spuStockIncrCounts -> {
            assertEquals(spuStockIncrCounts.size(), 1);
            assertEquals(spuStockIncrCounts.get(10L), 10);
            return true;
        }));
    }

    @Test
    public void testUpdateSkuStock_decrSuccess() {
        // 准备参数
        ProductSkuUpdateStockReqDTO updateStockReqDTO = new ProductSkuUpdateStockReqDTO()
                .setItems(singletonList(new ProductSkuUpdateStockReqDTO.Item().setId(1L).setIncrCount(-10)));
        // mock 数据
        productSkuMapper.insert(randomPojo(ProductSkuDO.class, o -> o.setId(1L).setSpuId(10L).setStock(20)));

        // 调用
        productSkuService.updateSkuStock(updateStockReqDTO);
        // 断言
        ProductSkuDO sku = productSkuMapper.selectById(1L);
        assertEquals(sku.getStock(), 10);
        verify(productSpuService).updateSpuStock(argThat(spuStockIncrCounts -> {
            assertEquals(spuStockIncrCounts.size(), 1);
            assertEquals(spuStockIncrCounts.get(10L), -10);
            return true;
        }));
    }

    @Test
    public void testUpdateSkuStock_decrFail() {
        // 准备参数
        ProductSkuUpdateStockReqDTO updateStockReqDTO = new ProductSkuUpdateStockReqDTO()
                .setItems(singletonList(new ProductSkuUpdateStockReqDTO.Item().setId(1L).setIncrCount(-30)));
        // mock 数据
        productSkuMapper.insert(randomPojo(ProductSkuDO.class, o -> o.setId(1L).setSpuId(10L).setStock(20)));

        // 调用并断言
        AssertUtils.assertServiceException(() -> productSkuService.updateSkuStock(updateStockReqDTO),
                SKU_STOCK_NOT_ENOUGH);
    }

    @Test
    public void testDeleteSku_success() {
        // mock 数据
        ProductSkuDO dbSku = randomPojo(ProductSkuDO.class);
        productSkuMapper.insert(dbSku);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSku.getId();

        // 调用
        productSkuService.deleteSku(id);
        // 校验数据不存在了
        assertNull(productSkuMapper.selectById(id));
    }

    @Test
    public void testDeleteSku_notExists() {
        // 准备参数
        Long id = 1L;

        // 调用, 并断言异常
        assertServiceException(() -> productSkuService.deleteSku(id), SKU_NOT_EXISTS);
    }
}
