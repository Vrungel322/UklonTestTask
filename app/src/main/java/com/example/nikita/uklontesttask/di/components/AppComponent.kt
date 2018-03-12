package com.example.nikita.uklontesttask.di.components

import com.example.nikita.uklontesttask.di.modules.AppModule
import com.example.nikita.uklontesttask.main.MainActivityPresenter
import com.example.nikita.uklontesttask.profile.ProfileActivityPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nikita on 27.02.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(mPresenter: MainActivityPresenter)
  fun inject(mPresenter: ProfileActivityPresenter)
}