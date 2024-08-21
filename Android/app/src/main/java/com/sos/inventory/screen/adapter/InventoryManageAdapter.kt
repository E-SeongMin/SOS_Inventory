package com.sos.inventory.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ItemInventoryManageViewHolderBinding
import com.sos.inventory.screen.viewholder.InventoryManageViewHolder

class InventoryManageAdapter : ListAdapter<InventoryData, InventoryManageViewHolder>(itemCallBack) {

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<InventoryData>() {
            override fun areItemsTheSame(oldItem: InventoryData, newItem: InventoryData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: InventoryData, newItem: InventoryData): Boolean {
                return oldItem.cost == newItem.cost ||
                        oldItem.name == newItem.name ||
                        oldItem.price == newItem.price ||
                        oldItem.remainCnt == newItem.remainCnt ||
                        oldItem.requiredCnt == newItem.requiredCnt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryManageViewHolder {
        return InventoryManageViewHolder(ItemInventoryManageViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: InventoryManageViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    fun addList(list: MutableList<InventoryData>) {
        submitList(list)
    }
}