package top.metass.pro.module.member.controller.admin.user;

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

import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptHisDO;
import top.metass.pro.module.member.convert.user.MemberUserGptHisConvert;
import top.metass.pro.module.member.service.user.MemberUserGptHisService;

@Tag(name = "管理后台 - 会员gpt扩展历史")
@RestController
@RequestMapping("/member/user-gpt-his")
@Validated
public class MemberUserGptHisController {

    @Resource
    private MemberUserGptHisService userGptHisService;

    @PostMapping("/create")
    @Operation(summary = "创建会员gpt扩展历史")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:create')")
    public CommonResult<Long> createUserGptHis(@Valid @RequestBody MemberUserGptHisCreateReqVO createReqVO) {
        return success(userGptHisService.createUserGptHis(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新会员gpt扩展历史")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:update')")
    public CommonResult<Boolean> updateUserGptHis(@Valid @RequestBody MemberUserGptHisUpdateReqVO updateReqVO) {
        userGptHisService.updateUserGptHis(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除会员gpt扩展历史")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:delete')")
    public CommonResult<Boolean> deleteUserGptHis(@RequestParam("id") Long id) {
        userGptHisService.deleteUserGptHis(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员gpt扩展历史")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:query')")
    public CommonResult<MemberUserGptHisRespVO> getUserGptHis(@RequestParam("id") Long id) {
        MemberUserGptHisDO userGptHis = userGptHisService.getUserGptHis(id);
        return success(MemberUserGptHisConvert.INSTANCE.convert(userGptHis));
    }

    @GetMapping("/list")
    @Operation(summary = "获得会员gpt扩展历史列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:query')")
    public CommonResult<List<MemberUserGptHisRespVO>> getUserGptHisList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserGptHisDO> list = userGptHisService.getUserGptHisList(ids);
        return success(MemberUserGptHisConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得会员gpt扩展历史分页")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:query')")
    public CommonResult<PageResult<MemberUserGptHisRespVO>> getUserGptHisPage(@Valid MemberUserGptHisPageReqVO pageVO) {
        PageResult<MemberUserGptHisDO> pageResult = userGptHisService.getUserGptHisPage(pageVO);
        return success(MemberUserGptHisConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出会员gpt扩展历史 Excel")
    @PreAuthorize("@ss.hasPermission('member:user-gpt-his:export')")
    @OperateLog(type = EXPORT)
    public void exportUserGptHisExcel(@Valid MemberUserGptHisExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserGptHisDO> list = userGptHisService.getUserGptHisList(exportReqVO);
        // 导出 Excel
        List<MemberUserGptHisExcelVO> datas = MemberUserGptHisConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员gpt扩展历史.xls", "数据", MemberUserGptHisExcelVO.class, datas);
    }

}
