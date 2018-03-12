package com.example.nikita.uklontesttask.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by nikita on 12.03.2018.
 */
data class PostEntity(@SerializedName("userId")
@Expose val userId: Int? = null, @SerializedName("id")
@Expose val id: Int? = null, @SerializedName("title")
@Expose val title: String? = null, @SerializedName("body")
@Expose val body: String? = null) {
//  @SerializedName("userId")
//  @Expose
//  private var userId: Int? = null
//  @SerializedName("id")
//  @Expose
//  private var id: Int? = null
//  @SerializedName("title")
//  @Expose
//  private var title: String? = null
//  @SerializedName("body")
//  @Expose
//  private var body: String? = null

}