package com.example.nikita.uklontesttask.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.uklontesttask.R.layout
import com.example.nikita.uklontesttask.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity(),IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
  }
  override fun setUpUi() {
Timber.e("setUpUi")
  }
}
