package com.example.nikita.uklontesttask.di.modules

import com.example.nikita.uklontesttask.data.DataManager
import com.example.nikita.uklontesttask.data.local.DbHelper
import com.example.nikita.uklontesttask.data.remote.Api
import com.example.nikita.uklontesttask.data.remote.RestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by vrungel on 28.02.2018.
 */
@Module
class DataModule {
  @Provides
  @Singleton
  fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

  @Provides
  @Singleton
  fun provideRestApi(api: Api): RestApi = RestApi(api)

  @Provides
  @Singleton
  fun provideDbHelper(): DbHelper = DbHelper()


  @Provides
  @Singleton
  fun provideDataManager(restApi: RestApi, dbHelper: DbHelper): DataManager = DataManager(restApi,
      dbHelper)

}