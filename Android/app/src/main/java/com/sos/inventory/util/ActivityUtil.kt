package com.sos.inventory.util

import android.app.Activity
import android.content.Intent
import com.sos.inventory.screen.InventoryAddActivity
import com.sos.inventory.screen.InventoryCheckActivity
import com.sos.inventory.screen.MainActivity
import com.sos.inventory.screen.InventoryManageActivity

object ActivityUtil {

    fun startMainActivity(activity: Activity) {
        Intent(activity, MainActivity::class.java).run {
            activity.startActivity(this)
        }
    }

    fun startCheckInventoryActivity(activity: Activity) {
        Intent(activity, InventoryCheckActivity::class.java).run {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            activity.startActivity(this)
        }
    }

    fun startManageInventoryActivity(activity: Activity) {
        Intent(activity, InventoryManageActivity::class.java).run {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            activity.startActivity(this)
        }
    }

    fun startAddInventoryActivity(activity: Activity) {
        Intent(activity, InventoryAddActivity::class.java).run {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            activity.startActivity(this)
        }
    }
}