package com.example.nikita.uklontesttask.data.remote

import com.example.nikita.uklontesttask.data.models.PostEntity
import io.reactivex.Observable

/**
 * Created by nikita on 05.03.2018.
 */
class RestApi {

  private var api: Api

  constructor(api: Api) {
    this.api = api
  }

  fun fetchPosts(): Observable<List<PostEntity>> = api.fetchPosts()

}