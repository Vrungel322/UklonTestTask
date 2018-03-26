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
data class Address(

    @SerializedName("street")
    @Expose
    val street: String? = null,
    @SerializedName("suite")
    @Expose
    val suite: String? = null,
    @SerializedName("city")
    @Expose
    val city: String? = null,
    @SerializedName("zipcode")
    @Expose
    val zipcode: String? = null,
    @SerializedName("geo")
    @Expose
    val geo: Geo? = null) : Parcelable {

}