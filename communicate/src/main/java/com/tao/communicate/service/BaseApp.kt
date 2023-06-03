package com.tao.communicate.service

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.tao.communicate.BuildConfig

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 1:27 PM
 */
open class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}