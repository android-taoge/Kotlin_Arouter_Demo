package com.tao.login.proto_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.tao.login.datastore.UserPreferences

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/15 10:19 PM
 */
private const val USER_PREFERENCES_NAME = "user_preferences"
private const val DATA_STORE_FILE_NAME = "user_prefs.pb"
private const val SORT_ORDER_KEY = "sort_order"

val Context.userPreferencesStore: DataStore<UserPreferences> by dataStore(
    fileName = DATA_STORE_FILE_NAME,
    serializer = UserPreferencesSerializer
)


