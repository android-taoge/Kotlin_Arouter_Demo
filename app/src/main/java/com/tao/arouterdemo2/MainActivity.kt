package com.tao.arouterdemo2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.tao.communicate.service.IUserService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_test).apply {
            setOnClickListener {
                ARouter.getInstance().build("/login/home").navigation()
//                val userInfoService =ARouter.getInstance().build("/login/userinfo").navigation() as IUserService
//                text=userInfoService.getUserToken()
            }
        }
    }
}