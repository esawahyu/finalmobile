package com.d121211010.NBA

import android.app.Application
import com.d121211010.NBA.data.AppContainer
import com.d121211010.NBA.data.DefaultAppContainer


class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}