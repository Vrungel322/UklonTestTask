package com.example.nikita.uklontesttask.data.local

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import timber.log.Timber
import java.util.ArrayList

/**
 * Created by nikita on 27.03.2018.
 */
class DbHelper {

  private var mConfiguration: RealmConfiguration = RealmConfiguration.Builder().name(
      "com.example.nikita.uklontesttask")
      //new version
      .schemaVersion(1).deleteRealmIfMigrationNeeded().build()

  init {
    Realm.setDefaultConfiguration(mConfiguration)
    Realm.getInstance(mConfiguration)
  }

  fun <T : RealmObject> save(obj: T) {

    val realm = Realm.getInstance(mConfiguration)
    realm.beginTransaction()
    realm.copyToRealmOrUpdate(obj)
    realm.commitTransaction()
  }

  /**
   * Проверяет есть ли елемент типа #Class с полем #field у которого значение #value в таблице бд
   * (соррян за рус комменты)
   */
  fun <T : RealmObject> isExists(clazz: Class<T>, field: String, value: String): Boolean {
    val realm = Realm.getInstance(mConfiguration)
    val query = realm.where(clazz).equalTo(field, value)

    return query.count() != 0L
  }

  fun <T : RealmObject> getAll(clazz: Class<T>): List<T> {
    var list: List<T> = ArrayList()
    val realm = Realm.getInstance(mConfiguration)
    realm.beginTransaction()
    list = realm.where(clazz).findAll()
    realm.commitTransaction()
    return realm.copyFromRealm(list) // Returns List , NOT RealmList
  }

  fun <T : RealmObject> getElementById(clazz: Class<T>, id: Int): T? {

    val realm = Realm.getInstance(mConfiguration)
    val query = realm.where(clazz).equalTo("id", id)

    var t: T?
    try {
      t = clazz.newInstance()
    } catch (e: InstantiationException) {
      e.printStackTrace()
    } catch (e: IllegalAccessException) {
      e.printStackTrace()
    }

    realm.beginTransaction()
    t = query.findFirst()
    realm.commitTransaction()
    return t
  }

  fun <T : RealmObject> getElementsFromDBByQuery(clazz: Class<T>, field: String,
      value: String): List<T> {

    val realm = Realm.getInstance(mConfiguration)
    val query = realm.where(clazz).equalTo(field, value)

    var list: List<T> = ArrayList()
    realm.beginTransaction()
    list = query.findAll()
    realm.commitTransaction()
    return realm.copyFromRealm(list) // Returns List , NOT RealmList
  }

  fun <T : RealmObject> dropRealmTable(clazz: Class<T>) {
    val results = Realm.getInstance(mConfiguration).where(clazz).findAll()

    // All changes to data must happen in a transaction
    Realm.getInstance(mConfiguration).beginTransaction()

    // Delete all matches
    results.deleteAllFromRealm()

    Realm.getInstance(mConfiguration).commitTransaction()
    Realm.getInstance(mConfiguration).close()
    Timber.e("clearRealm " + clazz.toString())
  }
}