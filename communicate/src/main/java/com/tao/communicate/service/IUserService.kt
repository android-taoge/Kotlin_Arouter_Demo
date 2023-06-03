package com.tao.communicate.service

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 1:15 PM
 */
interface IUserService:IProvider {
    fun getUserToken():String
}