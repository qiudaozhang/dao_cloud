package com.qiudaozhang.core.common.util

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * @author qiudaozhang
 * @since 2022-8-24
 * 日期工具类(仅仅针对java8的日期时间)
 */
object Time8Util {

    /**
     * 获取今天的起点时间
     */
    fun todayBegin(): LocalDateTime {
        val now = LocalDate.now()
        return now.atStartOfDay()
    }

    /**
     * 获取今天时间的结束点
     */
    fun todayEnd(): LocalDateTime {
        return todayBegin().plusDays(1).minusNanos(1)
    }

}