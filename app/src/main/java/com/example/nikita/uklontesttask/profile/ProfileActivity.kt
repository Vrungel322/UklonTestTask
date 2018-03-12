package com.example.nikita.uklontesttask.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nikita.uklontesttask.R
import com.example.nikita.uklontesttask.data.models.PostEntity
import timber.log.Timber

class ProfileActivity : AppCompatActivity() {
  lateinit var postEntity:PostEntity

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_profile)
    postEntity = intent.getParcelableExtra(PostEntity.POST_ENTITY)
    Timber.e(postEntity.toString())

  }
}
