package com.example.nikita.uklontesttask.main

import android.os.Bundle
import com.example.nikita.uklontesttask.R.layout
import com.example.nikita.uklontesttask.base.BaseActivity

class MainActivity : BaseActivity() {
//  @InjectPresenter lateinit var mPresenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
  }
  override fun setUpUi() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
