package com.example.nikita.uklontesttask.data.remote

import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by nikita on 05.03.2018.
 */
class RestApi {

  private var api: Api

  constructor(api: Api) {
    this.api = api
  }
  fun fetchPosts(): Observable<List<PostEntity>> = api.fetchPosts()
  fun fetchUser(userId: String): Observable<Response<UserEntity>> = api.fetchUser(userId)
  fun fetchComments(postId: String): Observable<Response<List<CommentEntity>>> = api.fetchComments(postId)


}