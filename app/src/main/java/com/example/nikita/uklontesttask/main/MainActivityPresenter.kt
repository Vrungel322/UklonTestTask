package com.example.nikita.uklontesttask.main

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.uklontesttask.App
import com.example.nikita.uklontesttask.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by nikita on 12.03.2018.
 */
@InjectViewState
class MainActivityPresenter : BasePresenter<IMainActivityView>() {
  override fun init() {
    App.sAppComponent.inject(this)
  }

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    fetchPosts()
  }

  fun fetchPosts() {
    val subscription: Disposable = mDataManager.fetchPosts().subscribeOn(
        Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
      Timber.e("" + t.size)
      viewState.addPosts(t)
    }, { t: Throwable ->
      t.printStackTrace()
      viewState.hideSwipeRefresh()
    })

    addToUnsubscription(subscription)
  }
}