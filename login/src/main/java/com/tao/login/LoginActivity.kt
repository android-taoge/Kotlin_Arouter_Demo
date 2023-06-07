package com.tao.login

import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.tao.baselibrary.base.BaseTitleActivity
import com.tao.baselibrary.base.LoadService
import com.tao.login.databinding.ActivityLoginBinding

@Route(path = "/login/home")
class LoginActivity : BaseTitleActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mBinding.tvLogin.setOnClickListener {
            Toast.makeText(this,"点击了登录",Toast.LENGTH_SHORT).show()
        }
    }

    override fun initData() {

    }

    override fun bindView(): View {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        return mBinding.root
    }


    override fun titleText(): String {
        return intent.getStringExtra("title") ?: ""
    }

}