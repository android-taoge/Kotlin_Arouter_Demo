package com.tao.arouterdemo2

import android.util.Log
import android.widget.TextView
import com.alibaba.android.arouter.launcher.ARouter
import com.tao.baselibrary.base.BaseActivity
import com.tao.baselibrary.base.BaseTitleActivity
import com.tao.baselibrary.base.LoadService
import com.tao.communicate.service.IUserService

class MainActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        findViewById<TextView>(R.id.tv_test).apply {
            setOnClickListener {
                ARouter.getInstance().build("/login/home").withString("title","主页传递过来的标题").navigation()
//                val userInfoService =ARouter.getInstance().build("/login/userinfo").navigation() as IUserService
//                text=userInfoService.getUserToken()
            }
        }
    }

    override fun initData() {

    }


    override fun onLoadService(loadService: LoadService) {
        super.onLoadService(loadService)

    }



//    override fun titleText(): String {
//        return "我是主页标题"
//    }
}