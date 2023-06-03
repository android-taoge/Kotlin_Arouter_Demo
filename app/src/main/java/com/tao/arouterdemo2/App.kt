package com.tao.arouterdemo2

import com.alibaba.android.arouter.launcher.ARouter
import com.tao.baselibrary.base.BaseApp

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 12:56 PM
 */
class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }


}