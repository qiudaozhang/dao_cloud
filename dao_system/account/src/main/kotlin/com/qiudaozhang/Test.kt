package com.qiudaozhang

import cn.dev33.satoken.secure.SaSecureUtil

class Test {
}

fun main() {
    val pair = SaSecureUtil.rsaGenerateKeyPair()
//    print(pair)
    val privateKey = pair["private"]
    val publicKey = pair["public"]
    println(privateKey)
    println()
    println(publicKey)
    println()

    val encrypt = SaSecureUtil.rsaEncryptByPublic(publicKey,"123")
    println(encrypt)
    val decrypt = SaSecureUtil.rsaDecryptByPrivate(privateKey,encrypt)
    println(decrypt)
}