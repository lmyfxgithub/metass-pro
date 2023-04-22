package top.metass.pro.module.member.api.spu;

import top.metass.pro.module.member.api.spu.dto.MemberSpuRespDTO;
import top.metass.pro.module.member.api.user.MemberUserApi;
import top.metass.pro.module.member.api.user.dto.MemberUserRespDTO;
import top.metass.pro.module.member.convert.spu.SpuConvert;
import top.metass.pro.module.member.convert.user.UserConvert;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.member.service.spu.SpuService;
import top.metass.pro.module.member.service.user.MemberUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 会员用户的 API 实现类
 *
 * @author 三生宇宙
 */
@Service
@Validated
public class MemberSpuApiImpl implements MemberSpuApi {

    @Resource
    private SpuService spuService;


    @Override
    public MemberSpuRespDTO getSpu(Long id) {
        return SpuConvert.INSTANCE.convert3(spuService.getSpu(id));
    }

    @Override
    public List<MemberSpuRespDTO> getDoSpuList(MemberSpuRespDTO supVO) {

        return  SpuConvert.INSTANCE.convertList03(spuService.getDoSpuList(SpuConvert.INSTANCE.convert(supVO)));
    }


}
