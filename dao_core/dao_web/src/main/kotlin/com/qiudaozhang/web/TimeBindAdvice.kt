package com.qiudaozhang.web

import com.qiudaozhang.core.common.consts.TimeConst
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.beans.PropertyEditorSupport
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter


/**
 * 普通web请求参数关于日志的绑定处理
 * @author qiudaozhang
 * @since 2022-8-24
 */
@RestControllerAdvice
class TimeBindAdvice {


    @InitBinder
    fun initBind(binder: WebDataBinder) {

        binder.registerCustomEditor(LocalDateTime::class.java, object : PropertyEditorSupport() {
            override fun setAsText(text: String?) {
                value = LocalDateTime.parse(text, DateTimeFormatter.ofPattern(TimeConst.YMD_HMS))
            }
        })
        binder.registerCustomEditor(LocalDate::class.java, object : PropertyEditorSupport() {
            override fun setAsText(text: String?) {
                value = LocalDate.parse(text, DateTimeFormatter.ofPattern(TimeConst.YMD))
            }
        })
        binder.registerCustomEditor(LocalTime::class.java, object : PropertyEditorSupport() {
            override fun setAsText(text: String?) {
                value = LocalTime.parse(text, DateTimeFormatter.ofPattern(TimeConst.HMS))
            }
        })

    }

}