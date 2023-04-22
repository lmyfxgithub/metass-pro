package top.metass.pro.module.member.convert.auth;

import top.metass.pro.module.member.controller.app.auth.vo.*;
import top.metass.pro.module.member.controller.app.social.vo.AppSocialUserUnbindReqVO;
import top.metass.pro.module.system.api.oauth2.dto.OAuth2AccessTokenRespDTO;
import top.metass.pro.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import top.metass.pro.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import top.metass.pro.module.system.api.social.dto.SocialUserBindReqDTO;
import top.metass.pro.module.system.api.social.dto.SocialUserUnbindReqDTO;
import top.metass.pro.module.system.enums.sms.SmsSceneEnum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConvert {

    AuthConvert INSTANCE = Mappers.getMapper(AuthConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, AppAuthSocialLoginReqVO reqVO);
    SocialUserUnbindReqDTO convert(Long userId, Integer userType, AppSocialUserUnbindReqVO reqVO);

    SmsCodeSendReqDTO convert(AppAuthSmsSendReqVO reqVO);
    SmsCodeUseReqDTO convert(AppAuthResetPasswordReqVO reqVO, SmsSceneEnum scene, String usedIp);
    SmsCodeUseReqDTO convert(AppAuthSmsLoginReqVO reqVO, Integer scene, String usedIp);

    AppAuthLoginRespVO convert(OAuth2AccessTokenRespDTO bean);

}
