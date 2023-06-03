package com.tao.baselibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tao.baselibrary.baseextra.IActivity

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 11:29 PM
 */
abstract class BaseActivity:AppCompatActivity(),IActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(layoutId())
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        initData()
    }


}