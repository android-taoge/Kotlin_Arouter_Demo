package com.tao.baselibrary.base

import android.app.Application
import com.tao.baselibrary.lifecyclecallback.NormalActivityCallback
import com.tao.baselibrary.lifecyclecallback.TitleBarActivityCallback

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 10:46 PM
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(NormalActivityCallback())
        registerActivityLifecycleCallbacks(TitleBarActivityCallback())
    }
}