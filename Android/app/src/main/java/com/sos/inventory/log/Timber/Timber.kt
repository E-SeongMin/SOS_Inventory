package com.sos.inventory.log.Timber

import timber.log.Timber

object Timber {

    fun init() {
        Timber.uprootAll()
        Timber.plant(CustomDebugTree())
    }
}