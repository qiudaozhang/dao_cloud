package com.qiudoazhang.db

import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.OutputFile
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.rules.DateType
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.util.*


class CodeGen {
}

fun main() {
    val url = "jdbc:mysql://localhost:33060/dao_account"
    val username = "root"
    val password = "root"
    FastAutoGenerator.create(url, username, password)
        .globalConfig { builder: GlobalConfig.Builder ->
            builder.author("qiudaozhang") // 设置作者
                .enableSwagger() // 开启 swagger 模式
                .dateType(DateType.TIME_PACK) // 文件覆盖比较危险 ，没有开启
                .commentDate("yyyy-MM-dd")
                .enableKotlin() // 如果需要使用kotlin 这里需要指定
                .outputDir("D:codegen//") // 指定输出目录
        }
        .packageConfig { builder: PackageConfig.Builder ->
            builder.parent("com.qiudaozhang") // 设置父包名
                .moduleName("account") // 设置父包模块名
                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:codegen//")) // 设置mapperXml生成路径
        }
        .strategyConfig { builder: StrategyConfig.Builder ->

            builder.addInclude("account") // 设置需要生成的表名
                .addTablePrefix("t_", "c_") // 设置过滤表前缀
        }
        .templateEngine(FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute()
}