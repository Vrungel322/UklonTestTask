package com.example.nikita.uklontesttask.profile

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.uklontesttask.R
import com.example.nikita.uklontesttask.base.BaseActivity
import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity
import com.example.nikita.uklontesttask.utils.ItemClickSupport
import kotlinx.android.synthetic.main.activity_profile.rvComments
import kotlinx.android.synthetic.main.activity_profile.srlComments
import kotlinx.android.synthetic.main.activity_profile.tvCompanyName
import kotlinx.android.synthetic.main.activity_profile.tvEmail
import kotlinx.android.synthetic.main.activity_profile.tvName
import kotlinx.android.synthetic.main.activity_profile.tvPhone
import kotlinx.android.synthetic.main.activity_profile.tvUserName
import kotlinx.android.synthetic.main.activity_profile.tvWebsite
import timber.log.Timber

class ProfileActivity : BaseActivity(), IProfileActivityView {
  @InjectPresenter
  lateinit var mPresenter: ProfileActivityPresenter
  lateinit var postEntity: PostEntity
  lateinit var commentsAdapter: CommentsAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_profile)
    super.onCreate(savedInstanceState)
    postEntity = intent.getParcelableExtra(PostEntity.POST_ENTITY)
    Timber.e(postEntity.toString())
    mPresenter.fetchUser(postEntity.userId)
    mPresenter.fetchComments(postEntity.id)

  }

  override fun setUpUi() {
    commentsAdapter = CommentsAdapter()
    rvComments.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,
        false)
    rvComments.adapter = commentsAdapter
    ItemClickSupport.addTo(rvComments).setOnItemClickListener { recyclerView, position, v ->
    }

    srlComments.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
    srlComments.setOnRefreshListener({
      mPresenter.fetchComments(postEntity.id)
    })
  }

  override fun showUser(userEntity: UserEntity) {
    tvName.text = userEntity.name
    tvUserName.text = userEntity.username
    tvEmail.text = userEntity.email
    tvPhone.text = userEntity.phone
    tvCompanyName.text = userEntity.company?.name
    tvWebsite.text = userEntity.website
  }

  override fun showComments(body: List<CommentEntity>) {
    srlComments.isRefreshing = false
    Toast.makeText(applicationContext, "Refreshed", Toast.LENGTH_SHORT).show()
    commentsAdapter.addEntities(body)
  }
}
