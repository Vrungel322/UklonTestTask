package com.example.nikita.uklontesttask.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.uklontesttask.R
import com.example.nikita.uklontesttask.R.layout
import com.example.nikita.uklontesttask.base.BaseActivity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.profile.ProfileActivity
import com.example.nikita.uklontesttask.utils.ItemClickSupport
import kotlinx.android.synthetic.main.activity_main.rvPosts
import kotlinx.android.synthetic.main.activity_main.srlPosts
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
    ItemClickSupport.addTo(rvPosts).setOnItemClickListener { recyclerView, position, v ->
      Timber.e("setUpUi click " + position)
      val profileIntent = Intent(applicationContext,ProfileActivity::class.java)
      profileIntent.putExtra(PostEntity.POST_ENTITY,postsAdapter.getEntities().get(position))
      startActivity(profileIntent)
      overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity)
    }

    srlPosts.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
    srlPosts.setOnRefreshListener({
      mPresenter.fetchPosts()
    })
  }

  override fun addPosts(posts: List<PostEntity>) {
    srlPosts.isRefreshing = false
      Toast.makeText(applicationContext, "Refreshed", Toast.LENGTH_SHORT).show()
    postsAdapter.addEntities(posts)
  }
}
