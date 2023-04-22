package top.metass.pro.module.gpt.controller.app;

import top.metass.pro.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static top.metass.pro.framework.common.pojo.CommonResult.success;
/**
 * @author jiangdi
 * @version 2023/4/5 13:51 top.metass.pro.module.gpt.controller.user.AppGptTestController.java V1.0
 */
@Tag(name = "用户 App - Test")
@RestController
@RequestMapping("/gpt/test")
@Validated
public class AppGptTestController {

    @GetMapping("/get")
    @Operation(summary = "获取 test 信息")
    public CommonResult<String> get() {
        return success("true");
    }
}
