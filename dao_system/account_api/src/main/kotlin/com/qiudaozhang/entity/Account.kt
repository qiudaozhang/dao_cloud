package com.qiudaozhang.entity

import com.qiudaozhang.core.common.consts.StringPool
import com.qiudoazhang.db.BaseEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

/**
 * <p>
 *
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-24
 */
@ApiModel(value = "Account对象", description = "")
class Account : BaseEntity(), Serializable {

    @ApiModelProperty("用户名")
    var username: String = StringPool.EMPTY

    @ApiModelProperty("密码")
    var password: String = StringPool.EMPTY

    override fun toString(): String {
        return "Account{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", created=" + created +
                ", updated=" + updated +
                ", deleted=" + deleted +
                "}"
    }
}

