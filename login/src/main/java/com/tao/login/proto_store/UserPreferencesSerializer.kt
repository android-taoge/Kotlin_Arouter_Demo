package com.tao.login.proto_store

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.tao.login.datastore.UserPreferences
import java.io.InputStream
import java.io.OutputStream

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/15 10:10 PM
 */
object UserPreferencesSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences
        get() = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        try {
            return UserPreferences.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("cannot read proto.", e)
        }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        t.writeTo(output)
    }
}