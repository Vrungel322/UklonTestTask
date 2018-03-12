package com.example.nikita.uklontesttask.data.remote

import com.example.nikita.uklontesttask.data.models.PostEntity
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by nikita on 12.03.2018.
 */
interface Api {
//  @GET("/1.1/statuses/home_timeline.json")
//  fun homeTimeline(@Query("count") count: Int = 20,
//      @Query("trim_user") trimUser: Boolean = true,
//      @Query("exclude_replies") excludeReplies: Boolean = true,
//      @Query("contributor_details") contributorDetails: Boolean = true,
//      @Query("include_entities") includeEntities: Boolean = true): Observable<List<Tweet>>

  @GET("posts")
  fun fetchPosts(): Observable<List<PostEntity>>
}