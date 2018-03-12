package com.example.nikita.uklontesttask.profile

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by vrungel on 12.03.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IProfileActivityView : MvpView {
}