package com.example.nikita.uklontesttask.data

import com.example.nikita.uklontesttask.data.local.DbHelper
import com.example.nikita.uklontesttask.data.models.CommentEntity
import com.example.nikita.uklontesttask.data.models.CommentRealmEntity
import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.models.user.UserEntity
import com.example.nikita.uklontesttask.data.remote.RestApi
import io.reactivex.Observable
import io.realm.RealmList
import retrofit2.Response

/**
 * Created by vrungel on 27.02.2018.
 */
class DataManager() {
  private lateinit var mRestApi: RestApi
  private lateinit var mDbHelper: DbHelper

  constructor(restApi: RestApi, dbHelper: DbHelper) : this() {
    mRestApi = restApi
    mDbHelper = dbHelper
  }

  fun getString(): String {
    return "Tempo"
  }

  fun fetchPosts(): Observable<List<PostEntity>> = mRestApi.fetchPosts()
  fun fetchUser(userId: String): Observable<Response<UserEntity>> = mRestApi.fetchUser(userId)
  fun fetchComments(
      postId: String): Observable<Response<List<CommentEntity>>> = mRestApi.fetchComments(
      postId)

  fun saveDbComments(commentsList: List<CommentEntity>) {
    mDbHelper.save(CommentRealmEntity(commentsList))
  }

  fun fetchDbComments(): RealmList<CommentEntity>? {
    return if (mDbHelper.getAll(CommentRealmEntity::class.java).isNotEmpty()){
      mDbHelper.getAll(CommentRealmEntity::class.java)[0].realmList
    }
    else{
      null
    }
  }

}