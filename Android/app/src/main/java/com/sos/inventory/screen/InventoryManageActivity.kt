package com.sos.inventory.screen

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sos.inventory.R
import com.sos.inventory.databinding.ActivityManageInventoryBinding
import com.sos.inventory.extension.toGone
import com.sos.inventory.extension.toResString
import com.sos.inventory.extension.toVisible
import com.sos.inventory.screen.adapter.InventoryManageAdapter
import com.sos.inventory.screen.base.BaseActivity
import com.sos.inventory.screen.viewmodel.InventoryViewModel
import com.sos.inventory.util.ActivityUtil

class InventoryManageActivity : BaseActivity<ActivityManageInventoryBinding, InventoryViewModel>() {

    override val layoutResID: Int
        get() = R.layout.activity_manage_inventory

    override val viewModel: InventoryViewModel = InventoryViewModel()

    private val adatper: InventoryManageAdapter by lazy {
        InventoryManageAdapter()
    }

    override fun init() {
        binding.apply {
            titleBar.tvTitle.text = String.format(R.string.manage_inventory_title.toResString)

            viewModel.getInventoryList().observe(this@InventoryManageActivity, Observer {
                if (it.isNullOrEmpty()) {
                    tvEmptyView.toVisible()
                    recylerView.toGone()
                } else {
                    tvEmptyView.toGone()
                    recylerView.toVisible()
                    recylerView.adapter = adatper
                    recylerView.layoutManager = LinearLayoutManager(this@InventoryManageActivity)
                    adatper.addList(it)
                }
            })
        }
    }

    override fun initListener() {
        binding.apply {
            titleBar.ivBack.setOnClickListener {
                onBackPressed()
            }

            btnAdd.setOnClickListener {
                ActivityUtil.startAddInventoryActivity(this@InventoryManageActivity)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}