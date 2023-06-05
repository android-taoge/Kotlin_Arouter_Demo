package com.tao.baselibrary.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tao.baselibrary.baseextra.IActivity

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 11:29 PM
 */
abstract class BaseActivity : AppCompatActivity(), IActivity {

    protected lateinit var mLoadService: LoadService

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(layoutId())
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onLoadService(loadService: LoadService) {
        mLoadService = loadService
        Log.e("loadService","==${mLoadService.hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        initData()
    }


}