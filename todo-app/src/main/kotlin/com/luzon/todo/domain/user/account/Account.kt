package com.luzon.todo.domain.user.account

import com.luzon.todo.domain.user.UserId
import java.security.MessageDigest



class Account private constructor(
        val userId: UserId,
        private var encryptedpassword: String) {

    fun changePassword(currentPassword: String, newPassword: String) {
        if(this.encryptedpassword != encrypt(currentPassword)){
            throw IncorrectPasswordException()
        }
        validate(newPassword)
        this.encryptedpassword = encrypt(newPassword)
    }

    companion object {
        private const val HEX_CHARS = "0123456789ABCDEF"

        fun createAccount(userId: UserId, password: String): Account {
            validate(password)
            return Account(userId, encrypt(password))
        }

        private fun validate(password: String) {
            if (password.length < 8) {
                throw IllegalArgumentException("password must have more than 8 characters")
            }
        }

        private fun encrypt(password: String): String {
            val md5 = MessageDigest.getInstance("MD5");
            md5.update(password.toByteArray())
            val sb = StringBuilder();
            md5.digest().forEach { byte ->
                val i = byte.toInt()
                sb.append(HEX_CHARS[i shr 4 and 0x0f])
                sb.append(HEX_CHARS[i and 0x0f])
            }
            return sb.toString()
        }

    }
}