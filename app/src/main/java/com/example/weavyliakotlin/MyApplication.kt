package com.example.weavyliakotlin

import android.app.Application
import android.media.MediaDrm
import com.facebook.stetho.okhttp3.BuildConfig


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //For chat logging
       MediaDrm.LogMessage.enableDebugLogging(BuildConfig.DEBUG)

        ChatSDK.Builder()
            .setDomainBaseUrl(BuildConfig.SDK_BASE_URL)
            .setLicenseKey(BuildConfig.LICENSE)
            .setIsTrialLicenceKey(true)
            .build()

    }
}



