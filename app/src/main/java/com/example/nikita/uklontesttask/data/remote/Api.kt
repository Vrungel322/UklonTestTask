package com.example.nikita.uklontesttask.data.remote

import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by nikita on 12.03.2018.
 */
interface Api {
  @GET("posts")
  fun fetchPosts(): Observable<List<PostEntity>>

  @GET("users/{userId}")
  fun fetchUser(@Path("userId") userId: String): Observable<Response<UserEntity>>

  @GET("posts/{postId}/comments")
  fun fetchComments(@Path("postId") postId: String): Observable<Response<List<CommentEntity>>>
}