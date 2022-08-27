package com.qiudaozhang.content.config

import cn.dev33.satoken.context.SaHolder
import cn.dev33.satoken.filter.SaServletFilter
import cn.dev33.satoken.id.SaIdUtil
import cn.dev33.satoken.util.SaResult
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * 子服务需要
 */
@Configuration
open class SaTokenConfigure : WebMvcConfigurer {

    @Bean
    open fun getSaServletFilter(): SaServletFilter? {
        return SaServletFilter()
            .addInclude("/content/**") // 注意不要写 /** 这样会覆盖到其它服务的路径，子服务管好自己的子路由即可
            .addExclude("/favicon.ico")
            .setAuth { obj: Any? ->
                // 校验 Id-Token 身份凭证     —— 以下两句代码可简化为：SaIdUtil.checkCurrentRequestToken();
                val token = SaHolder.getRequest().getHeader(SaIdUtil.ID_TOKEN)
                SaIdUtil.checkToken(token)
            }
            .setError { e: Throwable -> SaResult.error(e.message) }
    }
}