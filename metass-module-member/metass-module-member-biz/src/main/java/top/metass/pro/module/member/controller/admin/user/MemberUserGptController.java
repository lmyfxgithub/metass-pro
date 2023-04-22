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
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import top.metass.pro.module.member.convert.user.MemberUserGptConvert;
import top.metass.pro.module.member.service.user.MemberUserGptService;

@Tag(name = "管理后台 - 会员gpt扩展")
@RestController
@RequestMapping("/member/user-gpt")
@Validated
public class MemberUserGptController {

    @Resource
    private MemberUserGptService userGptService;

    @PostMapping("/create")
    @Operation(summary = "创建会员gpt扩展")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:create')")
    public CommonResult<Long> createUserGpt(@Valid @RequestBody MemberUserGptCreateReqVO createReqVO) {
        return success(userGptService.createUserGpt(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新会员gpt扩展")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:update')")
    public CommonResult<Boolean> updateUserGpt(@Valid @RequestBody MemberUserGptUpdateReqVO updateReqVO) {
        userGptService.updateUserGpt(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除会员gpt扩展")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:user-gpt:delete')")
    public CommonResult<Boolean> deleteUserGpt(@RequestParam("id") Long id) {
        userGptService.deleteUserGpt(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员gpt扩展")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:query')")
    public CommonResult<MemberUserGptRespVO> getUserGpt(@RequestParam("id") Long id) {
        MemberUserGptDO userGpt = userGptService.getUserGpt(id);
        return success(MemberUserGptConvert.INSTANCE.convert2(userGpt));
    }

    @GetMapping("/list")
    @Operation(summary = "获得会员gpt扩展列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:query')")
    public CommonResult<List<MemberUserGptRespVO>> getUserGptList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserGptDO> list = userGptService.getUserGptList(ids);
        return success(MemberUserGptConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得会员gpt扩展分页")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:query')")
    public CommonResult<PageResult<MemberUserGptRespVO>> getUserGptPage(@Valid MemberUserGptPageReqVO pageVO) {
        PageResult<MemberUserGptDO> pageResult = userGptService.getUserGptPage(pageVO);
        return success(MemberUserGptConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出会员gpt扩展 Excel")
    @PreAuthorize("@ss.hasPermission('member:user-gpt:export')")
    @OperateLog(type = EXPORT)
    public void exportUserGptExcel(@Valid MemberUserGptExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserGptDO> list = userGptService.getUserGptList(exportReqVO);
        // 导出 Excel
        List<MemberUserGptExcelVO> datas = MemberUserGptConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员gpt扩展.xls", "数据", MemberUserGptExcelVO.class, datas);
    }

}
