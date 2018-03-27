package com.example.nikita.uklontesttask.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


/**
 * Created by vrungel on 26.03.2018.
 */
open class CommentEntity(
    @SerializedName("postId")
    @Expose
    var postId: Int? = null,
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null,
    @SerializedName("body")
    @Expose
    var body: String? = null) : RealmObject() {

}