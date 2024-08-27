package com.sos.inventory.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ItemInventoryCheckViewHolderBinding
import com.sos.inventory.screen.listener.OnClickInventoryCheckListener
import com.sos.inventory.screen.viewholder.InventoryCheckViewHolder

class InventoryCheckAdapter : ListAdapter<InventoryData, InventoryCheckViewHolder>(itemCallBack) {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<InventoryData>() {
            override fun areItemsTheSame(oldItem: InventoryData, newItem: InventoryData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: InventoryData, newItem: InventoryData): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.cost == newItem.cost &&
                        oldItem.name == newItem.name &&
                        oldItem.price == newItem.price &&
                        oldItem.remainCnt == newItem.remainCnt &&
                        oldItem.requiredCnt == newItem.requiredCnt &&
                        oldItem.isCheck == newItem.isCheck
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryCheckViewHolder {
        return InventoryCheckViewHolder(ItemInventoryCheckViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClickInventoryCheckListener)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: InventoryCheckViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    fun addList(list: MutableList<InventoryData>) {
        val copyList = mutableListOf<InventoryData>()
        list.forEachIndexed { index, inventoryData ->
            copyList.add(InventoryData().apply {
                this.id = inventoryData.id
                this.isCheck = inventoryData.isCheck
                this.cost = inventoryData.cost
                this.name = inventoryData.name
                this.price = inventoryData.price
                this.requiredCnt = inventoryData.requiredCnt
                this.remainCnt = inventoryData.remainCnt
            })
        }

        submitList(copyList)
    }

    fun clearRemainCount(list: MutableList<InventoryData>) {
        val copyList = mutableListOf<InventoryData>()
        list.forEachIndexed { index, inventoryData ->
            copyList.add(InventoryData().apply {
                this.id = inventoryData.id
                this.isCheck = inventoryData.isCheck
                this.cost = inventoryData.cost
                this.name = inventoryData.name
                this.price = inventoryData.price
                this.requiredCnt = inventoryData.requiredCnt
                this.remainCnt = 0
            })
        }

        submitList(copyList)
    }

    fun getSendList(): MutableList<InventoryData> {
        return currentList
    }

    private val onClickInventoryCheckListener = object : OnClickInventoryCheckListener {
        override fun onItemCheck(position: Int, remainCnt: Int) {
            currentList[position].remainCnt = remainCnt
        }
    }
}