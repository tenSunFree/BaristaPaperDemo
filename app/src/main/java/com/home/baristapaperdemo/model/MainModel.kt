package com.home.baristapaperdemo.model

import io.paperdb.Paper
import org.threeten.bp.LocalDateTime

class MainModel {

    // 聲明loginListener是一個函數(單方法接口), 入參String, 無返回值
    private lateinit var loginListener: (String) -> Unit

    fun login(account: String, password: String, listener: (String) -> Unit) {
        this.loginListener = listener
        val lastLoginTime = LocalDateTime.now().toString()
            .replace("T", " ")
        val loginPojo = LoginPojo(account, password, lastLoginTime)
        Paper.book().write("login", loginPojo)
        val success = "登入成功"
        listener(success)
    }
}