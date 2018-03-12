package com.example.nikita.uklontesttask.profile

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.uklontesttask.App
import com.example.nikita.uklontesttask.base.BasePresenter

/**
 * Created by vrungel on 12.03.2018.
 */
@InjectViewState
class ProfileActivityPresenter : BasePresenter<IProfileActivityView>() {
  override fun init() {
    App.sAppComponent.inject(this)
  }
}