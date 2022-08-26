package com.qiudaozhang.core.common.model

import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

open class DeletedModel : Serializable {
    @ApiModelProperty("逻辑删除 1 删除 0 未删除")
    var deleted: Int? = null
}