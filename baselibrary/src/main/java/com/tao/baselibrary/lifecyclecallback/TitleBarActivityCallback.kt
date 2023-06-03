package com.tao.baselibrary.lifecyclecallback

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.tao.baselibrary.R
import com.tao.baselibrary.baseextra.ITitleBar

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 10:51 PM
 */
class TitleBarActivityCallback : ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is ITitleBar) {
            val back = activity.findViewById<ImageView>(R.id.back)
            val tvTitle = activity.findViewById<TextView>(R.id.tv_title)
            tvTitle.text = activity.titleText()
            back.setOnClickListener {
                activity.onBackPressed()

            }
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