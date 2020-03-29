package com.home.baristapaperdemo.presenter

import com.home.baristapaperdemo.model.MainModel

class MainPresenter {

    private val model = MainModel()

    // 聲明loginListener是一個函數(單方法接口), 入參String, 無返回值
    private lateinit var loginListener: (String) -> Unit

    fun login(account: String, password: String, listener: (String) -> Unit) {
        this.loginListener = listener
        if (account.isEmpty() || password.isEmpty()) {
            val empty = "帳號或密碼不能為空"
            return listener(empty)
        }
        model.login(account, password) {
            listener(it)
        }
    }
}