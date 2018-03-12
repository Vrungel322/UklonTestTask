package com.example.nikita.uklontesttask.main

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.uklontesttask.App
import com.example.nikita.uklontesttask.base.BasePresenter

/**
 * Created by nikita on 12.03.2018.
 */
@InjectViewState
class MainActivityPresenter: BasePresenter<IMainActivityView>() {
  override fun init() {
    App.sAppComponent.inject(this)
  }
}