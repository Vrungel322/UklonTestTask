package com.example.nikita.uklontesttask.profile

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.uklontesttask.App
import com.example.nikita.uklontesttask.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by vrungel on 12.03.2018.
 */
@InjectViewState
class ProfileActivityPresenter : BasePresenter<IProfileActivityView>() {
  override fun init() {
    App.sAppComponent.inject(this)
  }

  fun fetchUser(userId: Int?) {
    val subscription: Disposable = mDataManager.fetchUser(userId.toString()).subscribeOn(
        Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
      val userEntity = t.body()
      Timber.e("fetchUser : body " + userEntity.toString() + "\n code:" + t.code())
      t.body()?.let { viewState.showUser(it) }
    }, { t: Throwable -> t.printStackTrace() })
    addToUnsubscription(subscription)
  }

  fun fetchComments(postId: Int?) {
    mDataManager.fetchDbComments()?.filter { it -> it.postId == postId }?.let { it1 ->
      viewState.showComments(it1)
    }
    val subscription: Disposable = mDataManager.fetchComments(postId.toString()).subscribeOn(
        Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
      Timber.e("fetchComments : body " + t.body()?.size + "\n code:" + t.code())
      t.body()?.let {
        viewState.showComments(it)
//        mDataManager.saveDbComments(it)
      }
      Timber.e("savedCount " + mDataManager.fetchDbComments()?.size)

    }, { t: Throwable -> t.printStackTrace() })
    addToUnsubscription(subscription)
  }
}