package com.sos.inventory.screen

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sos.inventory.R
import com.sos.inventory.databinding.ActivityCheckInventoryBinding
import com.sos.inventory.extension.toGone
import com.sos.inventory.extension.toResString
import com.sos.inventory.extension.toVisible
import com.sos.inventory.screen.adapter.InventoryCheckAdapter
import com.sos.inventory.screen.base.BaseActivity
import com.sos.inventory.screen.viewmodel.InventoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InventoryCheckActivity : BaseActivity<ActivityCheckInventoryBinding, InventoryViewModel>() {

    override val layoutResID: Int
        get() = R.layout.activity_check_inventory

    override val viewModel: InventoryViewModel = InventoryViewModel()

    private val adatper: InventoryCheckAdapter by lazy {
        InventoryCheckAdapter()
    }

    init {
        viewModel.clearCheck()
    }

    override fun init() {
        binding.apply {
            titleBar.tvTitle.text = String.format(R.string.check_inventory_title.toResString)
            viewModel.getInventoryList().observe(this@InventoryCheckActivity, Observer {
                if (it.isNullOrEmpty()) {
                    tvEmptyView.toVisible()
                    recylerView.toGone()
                } else {
                    tvEmptyView.toGone()
                    recylerView.toVisible()
                    recylerView.adapter = adatper
                    recylerView.layoutManager = LinearLayoutManager(this@InventoryCheckActivity)
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

            btnSend.setOnClickListener {
                viewModel.checkAllItemChecking().let { position ->
                    if (position == 0) {
                        showToast(String.format(R.string.check_inventory_list_success.toResString))
                        CoroutineScope(Dispatchers.IO).launch {
                            viewModel.sendInventoryCheckList(adatper.getSendList())
                        }
                        finish()
                    } else {
                        showToast(String.format(R.string.check_inventory_list_is_not_checked.toResString))
                        recylerView.scrollToPosition(position-1)
                    }
                }
            }

            btnClear.setOnClickListener {
                showToast(String.format(R.string.check_inventory_list_remain_count_clear.toResString))
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.getInventoryList().value?.let {
                        adatper.clearRemainCount(it)
                    }
                }
            }

            btnAllCheck.setOnClickListener {
                viewModel.setAllCheck()
                showToast(String.format(R.string.check_inventory_list_remain_all_check.toResString))
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.getInventoryList().value?.let {
                        adatper.setAllCheck(it)
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}