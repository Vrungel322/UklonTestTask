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
data class Geo(
    @SerializedName("lat")
    @Expose
    val lat: String? = null,
    @SerializedName("lng")
    @Expose
    val lng: String? = null) : Parcelable {

}