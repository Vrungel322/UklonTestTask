package com.example.nikita.uklontesttask.data

import com.example.nikita.uklontesttask.data.models.PostEntity
import com.example.nikita.uklontesttask.data.remote.RestApi
import io.reactivex.Observable

/**
 * Created by vrungel on 27.02.2018.
 */
class DataManager() {
  private lateinit var mRestApi: RestApi

  constructor(restApi: RestApi) : this() {
    mRestApi = restApi
  }

  fun getString(): String{
    return "Tempo"
  }

  fun fetchPosts(): Observable<List<PostEntity>> = mRestApi.fetchPosts()

}