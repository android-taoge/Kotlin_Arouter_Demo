package com.tao.communicate.service

/**
 * @Author tangtao
 * @Description:
 * @Date: 2023/6/14 8:09 PM
 */
object NotifyMsgManager {
    private var notifyListener: NotifyListener? = null

    fun setNotifyListener(listener: NotifyListener) {
        notifyListener = listener
    }

    fun notifyMsg(msg: String) {
        notifyListener?.onNotify(msg)

    }
}