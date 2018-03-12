package com.example.nikita.uklontesttask.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.uklontesttask.R.layout
import com.example.nikita.uklontesttask.base.BaseActivity
import com.example.nikita.uklontesttask.data.models.PostEntity
import kotlinx.android.synthetic.main.activity_main.rvPosts
import timber.log.Timber

class MainActivity : BaseActivity(), IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter
  private lateinit var postsAdapter: PostsAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(layout.activity_main)
    super.onCreate(savedInstanceState)

  }

  override fun setUpUi() {
    Timber.e("setUpUi")
    postsAdapter = PostsAdapter()
    rvPosts.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,
        false)
    rvPosts.adapter = postsAdapter
  }

  override fun addPosts(posts: List<PostEntity>) {

    postsAdapter.addEntities(posts)
  }
}
