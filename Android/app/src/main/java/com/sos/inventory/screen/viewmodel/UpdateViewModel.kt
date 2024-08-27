package com.sos.inventory.screen.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.EventListener
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ActivityMainBinding
import com.sos.inventory.log.LogUtil
import com.sos.inventory.network.firebase.FirebaseRepository
import com.sos.inventory.screen.base.BaseActivity
import com.sos.inventory.screen.base.BaseViewModel

class UpdateViewModel : BaseViewModel() {
    private var repository = FirebaseRepository()
    private var inventoryList: MutableLiveData<MutableList<InventoryData>> = MutableLiveData()

    init {
        setInventoryListData()
    }

    private fun setInventoryListData() {
        LogUtil.d("InventoryViewModel setInventoryListData")
        repository.getInventoryReference().addSnapshotListener(EventListener { value, error ->
            if (error != null) {
                LogUtil.d("getInventoryList error : $error")
                inventoryList.value = null
                return@EventListener
            }

            val inventoryListData: MutableList<InventoryData> = mutableListOf()
            for (doc in value!!) {
                val data = doc.toObject(InventoryData::class.java)
                inventoryListData.add(data)
            }

            inventoryListData.sortBy { it.id }

            inventoryList.value = inventoryListData

        })
    }
}