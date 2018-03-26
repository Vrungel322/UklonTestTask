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
data class Company(
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("catchPhrase")
    @Expose
    val catchPhrase: String? = null,
    @SerializedName("bs")
    @Expose
    val bs: String? = null) : Parcelable {

}