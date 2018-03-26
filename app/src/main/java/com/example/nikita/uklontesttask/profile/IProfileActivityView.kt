package com.example.nikita.uklontesttask.profile

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity

/**
 * Created by vrungel on 12.03.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IProfileActivityView : MvpView {
  fun showUser(userEntity: UserEntity)
  fun showComments(body: List<CommentEntity>)

}