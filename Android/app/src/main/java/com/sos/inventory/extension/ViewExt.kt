package com.sos.inventory.extension

import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.sos.inventory.application.MyApplication

fun View.toGone() {
    this.isVisible = false
}

fun View.toVisible() {
    this.isVisible = true
}

fun View.toInvisible() {
    this.isInvisible =  true
}