package com.sos.inventory.extension

import android.view.View
import com.sos.inventory.application.MyApplication

inline val Int.toResString: String get() = MyApplication.resources().getString(this)