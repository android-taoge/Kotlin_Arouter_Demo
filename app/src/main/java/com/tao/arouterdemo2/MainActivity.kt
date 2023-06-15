package com.tao.arouterdemo2

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.launcher.ARouter
import com.tao.arouterdemo2.databinding.ActivityMainBinding
import com.tao.baselibrary.base.BaseActivity
import com.tao.baselibrary.base.BaseTitleActivity
import com.tao.baselibrary.base.LoadService
import com.tao.communicate.service.IUserService
import com.tao.communicate.service.NotifyListener
import com.tao.communicate.service.NotifyMsgManager
import com.tao.login.proto_store.userPreferencesStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val userInfoService =
            ARouter.getInstance().build("/login/userinfo").navigation() as IUserService
        lifecycleScope.launch {
            userInfoService.userFlow().collect {
                mBinding.tvUser.text = it.toString()
            }
        }
        mBinding.tvTest.apply {
            setOnClickListener {
                ARouter.getInstance().build("/login/home").withString("title", "主页传递过来的标题")
                    .navigation()

            }
        }
    }

    override fun initData() {
        NotifyMsgManager.setNotifyListener(object : NotifyListener {
            override fun onNotify(msg: String) {
                //Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                mBinding.tvTest.text = msg
            }
        })
    }

    override fun bindView(): View {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        return mBinding.root
    }


    override fun onLoadService(loadService: LoadService) {
        super.onLoadService(loadService)

    }


//    override fun titleText(): String {
//        return "我是主页标题"
//    }
}