package com.example.nikita.uklontesttask.base

import android.os.Bundle
import com.arellomobile.mvp.MvpActivity
import com.example.nikita.uklontesttask.R

/**
 * Created by nikita on 27.02.2018.
 */
abstract class BaseActivity : MvpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpUi()
    }

    abstract fun setUpUi()

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity)
    }
}