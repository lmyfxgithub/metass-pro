package top.metass.pro.module.gpt.controller.admin;

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
 * @version 2023/4/5 13:44 top.metass.pro.module.gpt.controller.admin.GptTestController.java V1.0
 */

@Tag(name = "GPT管理后台 - Test")
@RestController
@RequestMapping("/gpt/test")
@Validated
public class GptTestController {

    @GetMapping("/get")
    @Operation(summary = "获取 test 信息")
    public CommonResult<String> get() {
        return success("true");
    }

}
