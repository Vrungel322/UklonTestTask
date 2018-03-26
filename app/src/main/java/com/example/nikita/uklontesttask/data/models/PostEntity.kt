package com.example.nikita.uklontesttask.data.models

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by nikita on 12.03.2018.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class PostEntity(
    @SerializedName("userId")
    @Expose val userId: Int? = null,
    @SerializedName("id")
    @Expose val id: Int? = null,
    @SerializedName("title")
    @Expose val title: String? = null,
    @SerializedName("body")
    @Expose val body: String? = null) : Parcelable {
  companion object {
    val POST_ENTITY = "POST_ENTITY"
  }
}