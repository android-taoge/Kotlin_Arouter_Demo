package com.tao.baselibrary.base

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/5 9:55 PM
 */
class LoadSir {
    companion object{
        fun register(any: Any):LoadService {
            return LoadService(any)
        }
    }

}

class LoadService(any: Any)