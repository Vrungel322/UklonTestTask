package com.example.nikita.uklontesttask.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikita.uklontesttask.R
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.main.PostsAdapter.PostViewHolder
import kotlinx.android.synthetic.main.layout_item_post.view.tvPostBody
import kotlinx.android.synthetic.main.layout_item_post.view.tvPostTitle

/**
 * Created by vrungel on 12.03.2018.
 */
class PostsAdapter : RecyclerView.Adapter<PostViewHolder>() {
  var postList: MutableList<PostEntity> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder? {
    val view = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_post, parent,
        false)
    return PostViewHolder(view)
  }

  override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
    holder?.bindPost(postList[position])
  }

  override fun getItemCount(): Int {
    return postList.size
  }

  fun addEntities(posts: List<PostEntity>) {
    postList.clear()
    postList.addAll(posts)
    notifyDataSetChanged()
  }

  class PostViewHolder : RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    fun bindPost(postEntity: PostEntity) {
      with(postEntity) {
        itemView.tvPostTitle.text = title
        itemView.tvPostBody.text = body
      }
    }


  }
}