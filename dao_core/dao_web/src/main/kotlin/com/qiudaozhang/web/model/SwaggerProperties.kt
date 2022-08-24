package com.qiudaozhang.web.model

import com.qiudaozhang.core.common.consts.StringConst

class SwaggerProperties {
    /**
     * API文档生成基础路径
     */
    var apiBasePackage: String = "com.qiudaozhang"

    /**
     * 是否要启用登录认证
     */
    var enableSecurity = false

    /**
     * 文档标题
     */
    var title: String = StringConst.EMPTY

    /**
     * 文档描述
     */
    var description: String = StringConst.EMPTY

    /**
     * 文档版本
     */
    var version: String = StringConst.EMPTY

    /**
     * 文档联系人姓名
     */
    var contactName: String = StringConst.EMPTY

    /**
     * 文档联系人网址
     */
    var contactUrl: String = StringConst.EMPTY

    /**
     * 文档联系人邮箱
     */
    var contactEmail: String = StringConst.EMPTY
}