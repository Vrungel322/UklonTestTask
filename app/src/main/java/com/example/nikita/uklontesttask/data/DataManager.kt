package com.example.nikita.uklontesttask.data

import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity
import com.example.nikita.uklontesttask.data.remote.RestApi
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by vrungel on 27.02.2018.
 */
class DataManager() {
  private lateinit var mRestApi: RestApi

  constructor(restApi: RestApi) : this() {
    mRestApi = restApi
  }

  fun getString(): String {
    return "Tempo"
  }

  fun fetchPosts(): Observable<List<PostEntity>> = mRestApi.fetchPosts()
  fun fetchUser(userId: String): Observable<Response<UserEntity>> = mRestApi.fetchUser(userId)
  fun fetchComments(postId: String): Observable<Response<List<CommentEntity>>> = mRestApi.fetchComments(
      postId)


}