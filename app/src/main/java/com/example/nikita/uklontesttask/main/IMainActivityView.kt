package com.example.nikita.uklontesttask.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by nikita on 12.03.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IMainActivityView : MvpView {
}