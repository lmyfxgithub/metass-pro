package top.metass.pro.framework.desensitize.core;

import top.metass.pro.framework.common.util.json.JsonUtils;
import top.metass.pro.framework.desensitize.core.regex.annotation.EmailDesensitize;
import top.metass.pro.framework.desensitize.core.regex.annotation.RegexDesensitize;
import top.metass.pro.framework.desensitize.core.annotation.Address;
import top.metass.pro.framework.desensitize.core.slider.annotation.BankCardDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.CarLicenseDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.ChineseNameDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.FixedPhoneDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.IdCardDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.PasswordDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.MobileDesensitize;
import top.metass.pro.framework.desensitize.core.slider.annotation.SliderDesensitize;
import top.metass.pro.framework.test.core.ut.BaseMockitoUnitTest;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link DesensitizeTest} 的单元测试
 */
public class DesensitizeTest extends BaseMockitoUnitTest {

    @Test
    public void test() {
        // 准备参数
        DesensitizeDemo desensitizeDemo = new DesensitizeDemo();
        desensitizeDemo.setNickname("三生宇宙");
        desensitizeDemo.setBankCard("9988002866797031");
        desensitizeDemo.setCarLicense("粤A66666");
        desensitizeDemo.setFixedPhone("01086551122");
        desensitizeDemo.setIdCard("530321199204074611");
        desensitizeDemo.setPassword("123456");
        desensitizeDemo.setPhoneNumber("13248765917");
        desensitizeDemo.setSlider1("ABCDEFG");
        desensitizeDemo.setSlider2("ABCDEFG");
        desensitizeDemo.setSlider3("ABCDEFG");
        desensitizeDemo.setEmail("1@email.com");
        desensitizeDemo.setRegex("你好，我是三生宇宙");
        desensitizeDemo.setAddress("北京市海淀区上地十街10号");
        desensitizeDemo.setOrigin("三生宇宙");

        // 调用
        DesensitizeDemo d = JsonUtils.parseObject(JsonUtils.toJsonString(desensitizeDemo), DesensitizeDemo.class);
        // 断言
        assertNotNull(d);
        assertEquals("芋***", d.getNickname());
        assertEquals("998800********31", d.getBankCard());
        assertEquals("粤A6***6", d.getCarLicense());
        assertEquals("0108*****22", d.getFixedPhone());
        assertEquals("530321**********11", d.getIdCard());
        assertEquals("******", d.getPassword());
        assertEquals("132****5917", d.getPhoneNumber());
        assertEquals("#######", d.getSlider1());
        assertEquals("ABC*EFG", d.getSlider2());
        assertEquals("*******", d.getSlider3());
        assertEquals("1****@email.com", d.getEmail());
        assertEquals("你好，我是*", d.getRegex());
        assertEquals("北京市海淀区上地十街10号*", d.getAddress());
        assertEquals("三生宇宙", d.getOrigin());
    }

    @Data
    public static class DesensitizeDemo {

        @ChineseNameDesensitize
        private String nickname;
        @BankCardDesensitize
        private String bankCard;
        @CarLicenseDesensitize
        private String carLicense;
        @FixedPhoneDesensitize
        private String fixedPhone;
        @IdCardDesensitize
        private String idCard;
        @PasswordDesensitize
        private String password;
        @MobileDesensitize
        private String phoneNumber;
        @SliderDesensitize(prefixKeep = 6, suffixKeep = 1, replacer = "#")
        private String slider1;
        @SliderDesensitize(prefixKeep = 3, suffixKeep = 3)
        private String slider2;
        @SliderDesensitize(prefixKeep = 10)
        private String slider3;
        @EmailDesensitize
        private String email;
        @RegexDesensitize(regex = "三生宇宙", replacer = "*")
        private String regex;
        @Address
        private String address;
        private String origin;

    }

}
