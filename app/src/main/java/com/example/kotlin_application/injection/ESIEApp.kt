package com.example.kotlin_application.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ESIEApp : Application() {

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@ESIEApp)
            // modules
            modules(presentationModule)
        }
    }
}
