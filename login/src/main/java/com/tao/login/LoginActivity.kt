package com.tao.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.tao.baselibrary.base.BaseTitleActivity
import com.tao.baselibrary.base.LoadService

@Route(path = "/login/home")
class LoginActivity : BaseTitleActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {

    }

    override fun initData() {

    }



    override fun titleText(): String {
        return intent.getStringExtra("title") ?: ""
    }

}