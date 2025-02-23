package com.slateblua.outpostpets

import android.app.Application
import com.slateblua.outpostpets.appmodule.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OutpostPetsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@OutpostPetsApp)
            modules(commonModule)
        }
    }
}