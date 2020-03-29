package com.home.baristapaperdemo.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.home.baristapaperdemo.model.LoginPojo
import com.home.baristapaperdemo.presenter.MainPresenter
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.home.baristapaperdemo.R.layout.activity_main)
        showLastLogin()
        setView()
    }

    @SuppressLint("SetTextI18n")
    private fun showLastLogin() {
        val loginPojo: LoginPojo? = Paper.book().read("login")
        loginPojo?.let {
            val account = it.account
            val password = it.password
            val lastLoginTime = it.lastLoginTime
            text_view_last_login.text = "帳號: $account\n密碼: $password\n上次登入時間: $lastLoginTime"
        }
    }

    private fun setView() {
        button_login.setOnClickListener {
            val account = edit_text_account.text.toString()
            val password = edit_text_password.text.toString()
            presenter.login(account, password) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                showLastLogin()
            }
        }
    }
}
