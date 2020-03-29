package com.home.baristapaperdemo

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import io.paperdb.Paper

class BPDApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initPaper()
        initThreeTenABP()
    }

    private fun initPaper() {
        Paper.init(applicationContext)
    }

    private fun initThreeTenABP() {
        AndroidThreeTen.init(this)
    }
}