package com.sos.inventory.screen.listener

import com.sos.inventory.data.InventoryData

interface OnClickInventoryCheckListener {
    fun onItemCheck(position: Int, remainCnt: Int)
}