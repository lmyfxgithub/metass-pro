package top.metass.pro.module.member.controller.admin.user;

import top.metass.pro.framework.excel.core.util.ExcelUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.common.pojo.CommonResult;
import static top.metass.pro.framework.common.pojo.CommonResult.success;

import top.metass.pro.framework.operatelog.core.annotations.OperateLog;
import static top.metass.pro.framework.operatelog.core.enums.OperateTypeEnum.*;

import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.member.convert.user.MemberUserConvert;
import top.metass.pro.module.member.service.user.MemberUserService;

@Tag(name = "管理后台 - 用户")
@RestController
@RequestMapping("/member/user")
@Validated
public class MemberUserController {

    @Resource
    private MemberUserService userService;

    @PostMapping("/create")
    @Operation(summary = "创建用户")
    @PreAuthorize("@ss.hasPermission('member:user:create')")
    public CommonResult<Long> createUser(@Valid @RequestBody MemberUserCreateReqVO createReqVO) {
        return success(userService.createUser(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户")
    @PreAuthorize("@ss.hasPermission('member:user:update')")
    public CommonResult<Boolean> updateUser(@Valid @RequestBody MemberUserUpdateReqVO updateReqVO) {
        userService.updateUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:user:delete')")
    public CommonResult<Boolean> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<MemberUserRespVO> getUser(@RequestParam("id") Long id) {
        MemberUserDO user = userService.getUser(id);
        return success(MemberUserConvert.INSTANCE.convert(user));
    }

    @GetMapping("/list")
    @Operation(summary = "获得用户列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<List<MemberUserRespVO>> getUserList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserDO> list = userService.getUserList(ids);
        return success(MemberUserConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户分页")
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<PageResult<MemberUserRespVO>> getUserPage(@Valid MemberUserPageReqVO pageVO) {
        PageResult<MemberUserDO> pageResult = userService.getUserPage(pageVO);
        return success(MemberUserConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户 Excel")
    @PreAuthorize("@ss.hasPermission('member:user:export')")
    @OperateLog(type = EXPORT)
    public void exportUserExcel(@Valid MemberUserExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserDO> list = userService.getUserList(exportReqVO);
        // 导出 Excel
        List<MemberUserExcelVO> datas = MemberUserConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户.xls", "数据", MemberUserExcelVO.class, datas);
    }

}
