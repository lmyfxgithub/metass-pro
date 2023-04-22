package top.metass.pro.framework.common.util.object;

import top.metass.pro.framework.common.pojo.PageParam;

/**
 * {@link top.metass.pro.framework.common.pojo.PageParam} 工具类
 *
 * @author 三生宇宙
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
