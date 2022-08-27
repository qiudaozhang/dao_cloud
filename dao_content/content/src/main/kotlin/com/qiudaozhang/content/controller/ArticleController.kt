package com.qiudaozhang.content.controller;

import cn.dev33.satoken.stp.StpUtil
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-27
 */
@RestController
@RequestMapping("/content/article")
@Api(tags = ["文章"])
class ArticleController {


    @GetMapping
    @ApiOperation("读取")
    fun get(): String {
        val loginId = StpUtil.getLoginId()
        println(loginId)
        return "ok"
    }


}
