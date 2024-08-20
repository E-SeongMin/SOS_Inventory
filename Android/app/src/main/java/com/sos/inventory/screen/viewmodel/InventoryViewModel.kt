package com.sos.inventory.screen.viewmodel

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.EventListener
import com.sos.inventory.data.InventoryData
import com.sos.inventory.log.LogUtil
import com.sos.inventory.network.firebase.FirebaseRepository
import com.sos.inventory.screen.base.BaseViewModel

class InventoryViewModel : BaseViewModel() {
    private var repository = FirebaseRepository()
    private var inventoryList : MutableLiveData<MutableList<InventoryData>> = MutableLiveData()

    init {
        setInventoryListData()
    }

    private fun setInventoryListData(){
        LogUtil.d("InventoryViewModel setInventoryListData")
        repository.getInventoryReference().addSnapshotListener(EventListener { value, error ->
            if (error != null) {
                LogUtil.d("getInventoryList error : $error")
                inventoryList.value = null
                return@EventListener
            }

            val inventoryListData : MutableList<InventoryData> = mutableListOf()
            for (doc in value!!) {
                val data = doc.toObject(InventoryData::class.java)
                inventoryListData.add(data)
            }

            inventoryListData.sortBy { it.id }

            inventoryList.value = inventoryListData

        })
    }

    fun getInventoryList(): MutableLiveData<MutableList<InventoryData>> {
        LogUtil.d("InventoryViewModel getInventoryList")
        return inventoryList
    }

    fun getInventoryListSize(): Int? {
        LogUtil.d("InventoryViewModel getInventoryListSize")
        return inventoryList.value?.size
    }

    fun sendInventoryCheckList(sendList: MutableList<InventoryData>) {
        LogUtil.d("InventoryViewModel sendInventoryCheckList")
        repository.sendInventoryRemainCountList(sendList)
    }

    fun addInventoryData(data: InventoryData) {
        LogUtil.d("InventoryViewModel addInventoryData")
        repository.addInventoryData(data)
    }

    fun clearCheck() {
        inventoryList.value?.forEach {
            it.isCheck = false
        }
    }

    fun checkAllItemChecking(): Int {
        inventoryList.value?.forEach {
            if (!it.isCheck) {
                return it.id
            }
        }

        return 0
    }
}