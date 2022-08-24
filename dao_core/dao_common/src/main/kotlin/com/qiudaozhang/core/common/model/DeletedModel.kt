package com.qiudaozhang.core.common.model

import io.swagger.annotations.ApiModelProperty

open class DeletedModel {
    @ApiModelProperty("逻辑删除 1 删除 0 未删除")
    var deleted: Int? = null
}