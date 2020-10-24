package com.android.api

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class AuthApi {

    companion object {
        private const val KEY_PRIVATE = "ff28c030a8a73b3f90bdbbaef598657e86ea4ba4"
        private const val KEY_PUBLIC = "2b67c95d9c57aee27f2b5ff6b525f681"
    }

    val timeStamp: String
        get() = System.currentTimeMillis().toString()

    val publicKey: String
        get() = KEY_PUBLIC

    val privateKey: String
        get() = KEY_PRIVATE

    var md5Key: String? = null
        get() {
            val input = timeStamp + KEY_PRIVATE + KEY_PUBLIC

            return try {
                val md = MessageDigest.getInstance("MD5")
                val messageDigest = md.digest(input.toByteArray())
                val number = BigInteger(1, messageDigest)
                var md5: String = number.toString(16)
                while (md5.length < 32) md5 = "0$md5"
                md5
            } catch (e: NoSuchAlgorithmException) {
                null
            }
        }
        private set

}