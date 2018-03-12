package com.example.nikita.uklontesttask.di.modules

import android.app.Application
import android.content.Context
import com.example.nikita.uklontesttask.data.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nikita on 27.02.2018.
 */
@Module(includes = arrayOf(RetrofitModule::class, DataModule::class))
class AppModule(private val application: Application) {
  @Provides
  @Singleton
  fun provideApplicationContext(): Context = application

  @Provides
  @Singleton
  fun provideDataManager(): DataManager = DataManager()

}