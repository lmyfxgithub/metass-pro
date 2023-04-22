package top.metass.pro.module.member.controller.app.spu;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

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

import top.metass.pro.module.member.controller.app.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import top.metass.pro.module.member.convert.spu.SpuConvert;
import top.metass.pro.module.member.service.spu.SpuService;

@Tag(name = "用户 APP - 会员商品")
@RestController
@RequestMapping("/member/spu")
@Validated
public class AppSpuController {

    @Resource
    private SpuService spuService;


    @GetMapping("/get")
    @Operation(summary = "获得会员商品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")

    public CommonResult<AppSpuRespVO> getSpu(@RequestParam("id") Long id) {
        SpuDO spu = spuService.getSpu(id);
        return success(SpuConvert.INSTANCE.convert2(spu));
    }


    @PostMapping("/list")
    @Operation(summary = "获得会员商品列表")
    public CommonResult<List<AppSpuRespVO>> getSpuList(@Valid AppSpuReqVO appSpuReqVO) {
        List<SpuDO> pageResult = spuService.getDoSpuList(SpuConvert.INSTANCE.convert(appSpuReqVO));
        return success(SpuConvert.INSTANCE.convertList2(pageResult));
    }

}
