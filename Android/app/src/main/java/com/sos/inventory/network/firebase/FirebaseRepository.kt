package com.sos.inventory.network.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.sos.inventory.data.InventoryData
import com.sos.inventory.log.LogUtil
import com.sos.inventory.network.firebase.FirebaseConst.FIRE_BASE_DB_TABLE_NAME

class FirebaseRepository {

    fun getInventoryReference(): CollectionReference {
        return FirebaseFirestore.getInstance().collection(FIRE_BASE_DB_TABLE_NAME)
    }

    fun addInventoryData(data: InventoryData) {
        FirebaseFirestore.getInstance().collection(FIRE_BASE_DB_TABLE_NAME).document(data.name).set(data)
    }

    fun sendInventoryRemainCountList(list: MutableList<InventoryData>) {
        val db = FirebaseFirestore.getInstance()
        list.forEach {
            LogUtil.d("sendInventoryRemainCountList ${it.name} : ${it.remainCnt}")
            db.collection(FIRE_BASE_DB_TABLE_NAME).document(it.name).set(it)
        }
    }
}