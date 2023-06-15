package com.tao.login

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.tao.baselibrary.base.BaseTitleActivity
import com.tao.login.databinding.ActivityLoginBinding
import com.tao.login.proto_store.userPreferencesStore
import kotlinx.coroutines.launch

@Route(path = "/login/home")
class LoginActivity : BaseTitleActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mBinding.tvLogin.setOnClickListener {

            //NotifyMsgManager.notifyMsg("我是点击登录的吐司")
            lifecycleScope.launch {
                userPreferencesStore.updateData { userPrefs ->
                    userPrefs.toBuilder()
                        .setUserId(2)
                        .setToken("hhhhhhhhhhhh")
                        .setPhone("15608716466")
                        .build()
                }
            }
        }

        mBinding.tvClear.setOnClickListener {
            lifecycleScope.launch {
                userPreferencesStore.updateData { userPrefs ->
                    userPrefs.toBuilder().clear().build()
                }
            }
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