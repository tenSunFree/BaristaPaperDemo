package com.home.baristapaperdemo

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.home.baristapaperdemo.view.MainActivity
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.clearText
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun firstTest() {
        Thread.sleep(1500)
        clickOn(R.id.button_login)
        Thread.sleep(1500)
        writeTo(R.id.edit_text_account, "testAccount")
        Thread.sleep(1500)
        writeTo(R.id.edit_text_password, "342rr4445gre6")
        Thread.sleep(1500)
        clearText(R.id.edit_text_password)
        Thread.sleep(1500)
        writeTo(R.id.edit_text_password, "testPassword")
        Thread.sleep(1500)
        clickOn(R.id.button_login)
        Thread.sleep(2500)
    }

    @Test
    fun secondTest() {
        Thread.sleep(1500)
        writeTo(R.id.edit_text_account, "testAccount2")
        Thread.sleep(1500)
        writeTo(R.id.edit_text_password, "8768hf4525")
        Thread.sleep(1500)
        clearText(R.id.edit_text_password)
        Thread.sleep(1500)
        writeTo(R.id.edit_text_password, "testPassword2")
        Thread.sleep(1500)
        clickOn(R.id.button_login)
        Thread.sleep(2500)
    }
}