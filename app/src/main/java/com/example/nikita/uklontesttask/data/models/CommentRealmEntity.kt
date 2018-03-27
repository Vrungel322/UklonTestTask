package com.example.nikita.uklontesttask.data.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by nikita on 27.03.2018.
 */
open class CommentRealmEntity() : RealmObject() {
  @PrimaryKey
  var id:Int = 0
  var realmList: RealmList<CommentEntity> = RealmList()


  constructor(list: List<CommentEntity>) : this() {
    realmList.clear()
    for (item in list) {
      realmList.add(item)
    }
  }
}