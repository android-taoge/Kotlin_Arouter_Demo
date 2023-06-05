package com.tao.baselibrary.baseextra

import com.tao.baselibrary.base.LoadService

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/3 11:34 PM
 */
interface IActivity {
    fun layoutId():Int
    fun initView()
    fun initData()

    fun onLoadService(loadService:LoadService)
}