package com.example.harryporterapiapp.base

import android.app.Application
import com.pluto.Pluto
import com.pluto.plugins.network.PlutoNetworkPlugin
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HarryPorterApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initializePluto(this)
    }

    private fun initializePluto(harryPorterApplication: Application) {
        Pluto.Installer(harryPorterApplication)
            .addPlugin(PlutoNetworkPlugin("network"))
            .install()
    }
}