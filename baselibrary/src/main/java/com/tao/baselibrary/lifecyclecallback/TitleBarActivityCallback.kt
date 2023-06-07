package com.tao.baselibrary.lifecyclecallback

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.tao.baselibrary.R
import com.tao.baselibrary.base.LoadService
import com.tao.baselibrary.base.LoadSir
import com.tao.baselibrary.baseextra.ITitleBar

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 10:51 PM
 */
class TitleBarActivityCallback : ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val windowContent = activity.findViewById<FrameLayout>(android.R.id.content)
        val loadService: LoadService
        if (activity is ITitleBar) {
            val childRoot = LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = matchLayoutParams()
            }
            val titleBar =
                LayoutInflater.from(activity).inflate(R.layout.layout_titlebar, null, false).apply {
                    layoutParams = wrapLayoutParams()
                }
            val content = activity.bindView()
//                LayoutInflater.from(activity).inflate(activity.layoutId(), null, false).apply {
//                    layoutParams = matchLayoutParams()
//                }
            if (content.parent != null) {
                (content.parent as ViewGroup).removeAllViews()
            }
            childRoot.removeAllViews()
            childRoot.addView(titleBar)
            childRoot.addView(content)
            windowContent.removeAllViews()
            windowContent.addView(childRoot)

            val back = titleBar.findViewById<ImageView>(R.id.back)
            val tvTitle = titleBar.findViewById<TextView>(R.id.tv_title)
            tvTitle.text = activity.titleText()
            back.setOnClickListener {
                activity.onBackPressed()
            }
            loadService = LoadSir.register(content)
            activity.onLoadService(loadService)
        }


    }

    private fun wrapLayoutParams(): ViewGroup.LayoutParams =
        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )


    private fun matchLayoutParams(): ViewGroup.LayoutParams =
        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )


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