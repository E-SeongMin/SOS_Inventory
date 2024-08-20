package com.sos.inventory.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.sos.inventory.log.Timber.Timber

class MyApplication: MultiDexApplication() {

    var appStatus = STATUS.FOREGROUND

    enum class STATUS {
        BACKGROUND,
        FOREGROUND
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        registerActivityLifecycleCallbacks(mActivityLifeCycleCallbacks)

        Timber.init()
    }

    private val mActivityLifeCycleCallbacks = object : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {

        }
    }

    companion object {

        private var instance: MyApplication? = null

        @JvmStatic
        fun applicationContext(): Context = instance!!.applicationContext

        @JvmStatic
        fun application(): Application = instance!!

        fun resources(): Resources = instance!!.applicationContext.resources

    }
}