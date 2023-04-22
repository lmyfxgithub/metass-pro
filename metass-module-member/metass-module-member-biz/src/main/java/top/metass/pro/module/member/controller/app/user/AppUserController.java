package top.metass.pro.module.member.controller.app.user;

import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.framework.security.core.annotations.PreAuthenticated;
import top.metass.pro.module.member.controller.app.user.vo.AppMemberUserGptRespVO;
import top.metass.pro.module.member.controller.app.user.vo.AppUserInfoRespVO;
import top.metass.pro.module.member.controller.app.user.vo.AppUserUpdateMobileReqVO;
import top.metass.pro.module.member.convert.user.MemberUserGptConvert;
import top.metass.pro.module.member.convert.user.UserConvert;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import top.metass.pro.module.member.service.user.MemberUserGptHisService;
import top.metass.pro.module.member.service.user.MemberUserGptService;
import top.metass.pro.module.member.service.user.MemberUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.framework.common.pojo.CommonResult.success;
import static top.metass.pro.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static top.metass.pro.module.infra.enums.ErrorCodeConstants.FILE_IS_EMPTY;

@Tag(name = "用户 APP - 用户个人中心")
@RestController
@RequestMapping("/member/user")
@Validated
@Slf4j
public class AppUserController {

    @Resource
    private MemberUserService userService;

    @Resource
    private MemberUserGptService memberUserGptService;

    @Resource
    private MemberUserGptHisService memberUserGptHisService;

    @PutMapping("/update-nickname")
    @Operation(summary = "修改用户昵称")
    @PreAuthenticated
    public CommonResult<Boolean> updateUserNickname(@RequestParam("nickname") String nickname) {
        userService.updateUserNickname(getLoginUserId(), nickname);
        return success(true);
    }

    @PostMapping("/update-avatar")
    @Operation(summary = "修改用户头像")
    @PreAuthenticated
    public CommonResult<String> updateUserAvatar(@RequestParam("avatarFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String avatar = userService.updateUserAvatar(getLoginUserId(), file.getInputStream());
        return success(avatar);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基本信息")
    @PreAuthenticated
    public CommonResult<AppUserInfoRespVO> getUserInfo() {
        MemberUserDO user = userService.getUser(getLoginUserId());
        return success(UserConvert.INSTANCE.convert(user));
    }

    @PostMapping("/update-mobile")
    @Operation(summary = "修改用户手机")
    @PreAuthenticated
    public CommonResult<Boolean> updateMobile(@RequestBody @Valid AppUserUpdateMobileReqVO reqVO) {
        userService.updateUserMobile(getLoginUserId(), reqVO);
        return success(true);
    }

    @GetMapping("/check-chat")
    @Operation(summary = "检查对话权限")
    @PreAuthenticated
    public CommonResult<AppMemberUserGptRespVO> checkChat() {
        MemberUserGptDO memberUserGptDO = memberUserGptService.checkChatInfo(getLoginUserId());
        return success(MemberUserGptConvert.INSTANCE.convert(memberUserGptDO));

    }

    @GetMapping("/get-chat-info")
    @Operation(summary = "获取chat信息")
    @PreAuthenticated
    public CommonResult<AppMemberUserGptRespVO> getChatInfo() {
        MemberUserGptDO memberUserGptDO = memberUserGptService.getChatInfo(getLoginUserId());
        return success(MemberUserGptConvert.INSTANCE.convert(memberUserGptDO));
    }

}

