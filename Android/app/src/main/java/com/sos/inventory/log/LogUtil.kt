package com.sos.inventory.log

import timber.log.Timber

object LogUtil {

    var logTag = "sos_log"

    @JvmStatic fun d(message: String, vararg args: Any?) {
        Timber.tag(logTag)
        Timber.d(message, *args)
    }
}