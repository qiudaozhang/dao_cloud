package com.qiudaozhang

import com.qiudaozhang.mapper.AccountMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
@MapperScan(basePackageClasses = [AccountMapper::class])
// 添加扫描，否则不生效

open class AccountApp

fun main(array: Array<String>) {
    runApplication<AccountApp>(*array)
}