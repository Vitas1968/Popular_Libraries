package com.google.vitaly.mvpapp

import android.app.Application

class App(): Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

      companion object {
          private var INSTANCE: App? = null
          @JvmStatic
          fun get(): App = INSTANCE!!

          fun getINSTANCE()=INSTANCE

      }


}