package com.tao.login.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.tao.communicate.bean.UserInfo
import com.tao.communicate.service.IUserService
import com.tao.login.proto_store.userPreferencesStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 1:15 PM
 */

@Route(path = "/login/userinfo")
class UserInfoService : IUserService {

    private lateinit var mContext: Context
    override fun userFlow(): Flow<UserInfo?> {
        return mContext.userPreferencesStore.data.catch {
            if (it is IOException) {
                throw IOException(it)
            }
        }.map {
            UserInfo(it.userId, it.token, it.phone)
        }

    }


    override fun init(context: Context) {
        mContext = context
    }
}