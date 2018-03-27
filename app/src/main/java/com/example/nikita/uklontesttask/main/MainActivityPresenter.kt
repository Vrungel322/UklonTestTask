package com.example.nikita.uklontesttask.main

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.uklontesttask.App
import com.example.nikita.uklontesttask.base.BasePresenter
import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by nikita on 12.03.2018.
 */
@InjectViewState
class MainActivityPresenter : BasePresenter<IMainActivityView>() {
  private val commentsList = ArrayList<CommentEntity>()
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
      storeComments(t)
    }, { t: Throwable ->
      t.printStackTrace()
      viewState.hideSwipeRefresh()
    })

    addToUnsubscription(subscription)
  }

  private fun storeComments(list: List<PostEntity>) {
    for (item in list) {
      val subscription: Disposable = mDataManager.fetchComments(item.id.toString()).subscribeOn(
          Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
        t.body()?.let { commentsList.addAll(it) }
        Timber.e("storeComments! size: " +t.body()?.size )
        Timber.e("storeComments size: " +commentsList.size )
      }, { t: Throwable ->
        t.printStackTrace()
      })

      addToUnsubscription(subscription)
    }
    mDataManager.saveDbComments(commentsList)
  }
}