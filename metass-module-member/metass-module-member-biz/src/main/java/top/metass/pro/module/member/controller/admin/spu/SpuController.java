package top.metass.pro.module.member.controller.admin.spu;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.common.pojo.CommonResult;
import static top.metass.pro.framework.common.pojo.CommonResult.success;

import top.metass.pro.framework.excel.core.util.ExcelUtils;

import top.metass.pro.framework.operatelog.core.annotations.OperateLog;
import static top.metass.pro.framework.operatelog.core.enums.OperateTypeEnum.*;

import top.metass.pro.module.member.controller.admin.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import top.metass.pro.module.member.convert.spu.SpuConvert;
import top.metass.pro.module.member.service.spu.SpuService;

@Tag(name = "管理后台 - 会员商品")
@RestController
@RequestMapping("/member/spu")
@Validated
public class SpuController {

    @Resource
    private SpuService spuService;

    @PostMapping("/create")
    @Operation(summary = "创建会员商品")
    @PreAuthorize("@ss.hasPermission('member:spu:create')")
    public CommonResult<Long> createSpu(@Valid @RequestBody SpuCreateReqVO createReqVO) {
        return success(spuService.createSpu(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新会员商品")
    @PreAuthorize("@ss.hasPermission('member:spu:update')")
    public CommonResult<Boolean> updateSpu(@Valid @RequestBody SpuUpdateReqVO updateReqVO) {
        spuService.updateSpu(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除会员商品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:spu:delete')")
    public CommonResult<Boolean> deleteSpu(@RequestParam("id") Long id) {
        spuService.deleteSpu(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员商品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:spu:query')")
    public CommonResult<SpuRespVO> getSpu(@RequestParam("id") Long id) {
        SpuDO spu = spuService.getSpu(id);
        return success(SpuConvert.INSTANCE.convert(spu));
    }

    @GetMapping("/list")
    @Operation(summary = "获得会员商品列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:spu:query')")
    public CommonResult<List<SpuRespVO>> getSpuList(@RequestParam("ids") Collection<Long> ids) {
        List<SpuDO> list = spuService.getSpuList(ids);
        return success(SpuConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得会员商品分页")
    @PreAuthorize("@ss.hasPermission('member:spu:query')")
    public CommonResult<PageResult<SpuRespVO>> getSpuPage(@Valid SpuPageReqVO pageVO) {
        PageResult<SpuDO> pageResult = spuService.getSpuPage(pageVO);
        return success(SpuConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出会员商品 Excel")
    @PreAuthorize("@ss.hasPermission('member:spu:export')")
    @OperateLog(type = EXPORT)
    public void exportSpuExcel(@Valid SpuExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpuDO> list = spuService.getSpuList(exportReqVO);
        // 导出 Excel
        List<SpuExcelVO> datas = SpuConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员商品.xls", "数据", SpuExcelVO.class, datas);
    }

}
