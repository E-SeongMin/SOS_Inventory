package com.sos.inventory.log.Timber

import androidx.multidex.BuildConfig
import timber.log.Timber

class CustomDebugTree: Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)
    }
}