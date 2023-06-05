package com.tao.baselibrary.lifecyclecallback

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.tao.baselibrary.base.LoadService
import com.tao.baselibrary.base.LoadSir
import com.tao.baselibrary.baseextra.IActivity

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 10:36 PM
 */
class NormalActivityCallback : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val loadService: LoadService
        if (activity is IActivity) {
            activity.layoutId()
            activity.initData()
            loadService = LoadSir.register(activity)
            activity.onLoadService(loadService)
        }
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}