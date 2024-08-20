package com.sos.inventory.screen.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ItemInventoryCheckViewHolderBinding
import com.sos.inventory.databinding.ItemInventoryManageViewHolderBinding
import com.sos.inventory.screen.listener.OnClickInventoryCheckListener

class InventoryCheckViewHolder(private val binding: ItemInventoryCheckViewHolderBinding, private val onClickInventoryCheckListener: OnClickInventoryCheckListener) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: InventoryData, position: Int) {
        binding.apply {
            tvName.text = item.name
            tvCount.text = item.remainCnt.toString()

            btnUp.setOnClickListener {
                if (!btnCheck.isSelected) {
                    tvCount.text.toString().toInt().let {
                        tvCount.text = (it + 1).toString()
                        onClickInventoryCheckListener.onItemCheck(position, it + 1)
                    }
                }
            }

            btnDown.setOnClickListener {
                if (!btnCheck.isSelected) {
                    tvCount.text.toString().toInt().let {
                        if (it > 0 ) {
                            tvCount.text = (it - 1).toString()
                            onClickInventoryCheckListener.onItemCheck(position, it - 1)
                        }
                    }
                }
            }

            btnCheck.setOnClickListener {
                if (btnCheck.isSelected) {
                    item.isCheck = false
                    btnCheck.isSelected = false
                } else {
                    item.isCheck = true
                    btnCheck.isSelected = true
                    onClickInventoryCheckListener.onItemCheck(position, tvCount.text.toString().toInt())
                }
            }
        }
    }
}