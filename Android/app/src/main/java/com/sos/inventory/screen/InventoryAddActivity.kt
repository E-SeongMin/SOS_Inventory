package com.sos.inventory.screen

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sos.inventory.R
import com.sos.inventory.data.InventoryData
import com.sos.inventory.databinding.ActivityAddInventoryBinding
import com.sos.inventory.databinding.ActivityCheckInventoryBinding
import com.sos.inventory.extension.toGone
import com.sos.inventory.extension.toResString
import com.sos.inventory.extension.toVisible
import com.sos.inventory.log.LogUtil
import com.sos.inventory.screen.adapter.InventoryCheckAdapter
import com.sos.inventory.screen.base.BaseActivity
import com.sos.inventory.screen.viewmodel.InventoryViewModel
import dagger.hilt.android.AndroidEntryPoint

class InventoryAddActivity : BaseActivity<ActivityAddInventoryBinding, InventoryViewModel>() {

    override val layoutResID: Int
        get() = R.layout.activity_add_inventory

    override val viewModel: InventoryViewModel = InventoryViewModel()

    override fun init() {

    }

    override fun initListener() {
        binding.apply {
            titleBar.ivBack.setOnClickListener {
                onBackPressed()
            }

            btnAdd.setOnClickListener {
                viewModel.getInventoryListSize()?.let {
                    var data = InventoryData().apply {
                        this.id = it + 1
                        this.name = etName.text.toString()
                        this.cost = etCost.text.toString().toInt()
                        this.price = etPrice.text.toString().toInt()
                        this.remainCnt = etRemainCnt.text.toString().toInt()
                        this.requiredCnt = etRequiredCnt.text.toString().toInt()
                    }
                    viewModel.addInventoryData(data)
                    finish()
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}