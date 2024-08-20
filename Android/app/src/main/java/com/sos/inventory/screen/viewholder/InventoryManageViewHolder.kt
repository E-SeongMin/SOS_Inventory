package com.sos.inventory.screen.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ItemInventoryManageViewHolderBinding

class InventoryManageViewHolder(private val binding: ItemInventoryManageViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: InventoryData) {
        binding.apply {
            tvName.text = item.name
            tvRemainCnt.text = item.remainCnt.toString()
            tvRequiredCnt.text = item.requiredCnt.toString()

            tvEdit.setOnClickListener {

            }
        }
    }
}