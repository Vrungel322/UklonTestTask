package com.example.nikita.uklontesttask

import android.app.Application
import com.example.nikita.uklontesttask.di.components.AppComponent
import com.example.nikita.uklontesttask.di.components.DaggerAppComponent
import com.example.nikita.uklontesttask.di.modules.AppModule
import timber.log.Timber

/**
 * Created by nikita on 12.03.2018.
 */
class App : Application() {
  companion object {
    lateinit var sAppComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    sAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}