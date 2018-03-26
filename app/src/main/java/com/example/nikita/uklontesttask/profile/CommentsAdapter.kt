package com.example.nikita.uklontesttask.profile

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikita.uklontesttask.R
import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.profile.CommentsAdapter.CommentViewHolder
import kotlinx.android.synthetic.main.layout_item_comment.view.tvCommentBody
import kotlinx.android.synthetic.main.layout_item_comment.view.tvCommentEmail
import kotlinx.android.synthetic.main.layout_item_comment.view.tvCommentName

/**
 * Created by vrungel on 26.03.2018.
 */
class CommentsAdapter : RecyclerView.Adapter<CommentViewHolder>() {
  var commentEntities: MutableList<CommentEntity> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommentViewHolder {
    val view = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_comment, parent,
        false)
    return CommentViewHolder(view)
  }

  override fun onBindViewHolder(holder: CommentViewHolder?, position: Int) {
    holder?.bindPost(commentEntities[position])
  }

  override fun getItemCount(): Int {
    return commentEntities.size
  }

  fun addEntities(comments: List<CommentEntity>) {
    commentEntities.clear()
    commentEntities.addAll(comments)
    notifyDataSetChanged()
  }

  fun getEntities() = commentEntities


  class CommentViewHolder : RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    fun bindPost(commentEntity: CommentEntity) {
      with(commentEntity) {
        itemView.tvCommentName.text = commentEntity.name
        itemView.tvCommentEmail.text = commentEntity.email
        itemView.tvCommentBody.text = commentEntity.body
      }
    }
  }
}