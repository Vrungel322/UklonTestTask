package com.example.nikita.uklontesttask.data.models.user

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by vrungel on 26.03.2018.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class UserEntity(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("username")
    @Expose
    val username: String? = null,
    @SerializedName("email")
    @Expose
    val email: String? = null,
    @SerializedName("address")
    @Expose
    val address: Address? = null,
    @SerializedName("phone")
    @Expose
    val phone: String? = null,
    @SerializedName("website")
    @Expose
    val website: String? = null,
    @SerializedName("company")
    @Expose
    val company: Company? = null) : Parcelable {
  companion object {
    val USER_ENTITY = "USER_ENTITY"
  }
}