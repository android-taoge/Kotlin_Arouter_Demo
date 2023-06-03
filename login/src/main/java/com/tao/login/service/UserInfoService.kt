package com.tao.login.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.tao.communicate.service.IUserService

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 1:15 PM
 */

@Route(path = "/login/userinfo")
class UserInfoService:IUserService {
    override fun getUserToken(): String {
        return "hdaferaeonigea"
    }

    override fun init(context: Context?) {
    }
}