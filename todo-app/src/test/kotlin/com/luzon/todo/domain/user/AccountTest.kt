package com.luzon.todo.domain.user

import com.luzon.todo.domain.user.account.Account
import com.luzon.todo.domain.user.account.IncorrectPasswordException
import org.junit.Test

class AccountTest {
    @Test(expected = IllegalArgumentException::class)
    fun passwordValidation() {
        Account.createAccount("testId", "aaaabbb")
    }

    @Test
    fun changePassword() {
        val oldPass = "aaaabbbb"
        val newPass = "ccccdddd"
        val account = Account.createAccount("testId", oldPass)
        account.changePassword(oldPass, newPass)
    }

    @Test(expected = IllegalArgumentException::class)
    fun changePasswordValidation() {
        val oldPass = "aaaabbbb"
        val newPass = "ccccddd"
        val account = Account.createAccount("testId", oldPass)
        account.changePassword(oldPass, newPass)
    }

    @Test(expected = IncorrectPasswordException::class)
    fun incorrectPass() {
        val oldPass = "aaaabbbb"
        val wrongPass = "ccccaaaa"
        val newPass = "ccccdddd"
        val account = Account.createAccount("testId", oldPass)
        account.changePassword(wrongPass, newPass)
    }
}