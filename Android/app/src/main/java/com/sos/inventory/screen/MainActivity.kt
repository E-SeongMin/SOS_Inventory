package com.sos.inventory.screen

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sos.inventory.R
import com.sos.inventory.databinding.ActivityMainBinding
import com.sos.inventory.screen.base.BaseActivity
import com.sos.inventory.screen.viewmodel.MainViewModel
import com.sos.inventory.util.ActivityUtil

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    override val layoutResID: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun init() {
        binding.apply {
            mainView.tvUpdateDate.text = ""
        }
    }

    override fun initListener() {
        binding.apply {
            mainView.apply {
                tvCheckInventory.setOnClickListener {
                    ActivityUtil.startCheckInventoryActivity(this@MainActivity)
                }

                tvCalculateCostRate.setOnClickListener {

                }

                tvManageInventory.setOnClickListener {
                    ActivityUtil.startManageInventoryActivity(this@MainActivity)
                }

                mainBar.ivToolBar.setOnClickListener {
                    toggleDrawerLayout(dlMain)
                }
            }

            naviView.setNavigationItemSelectedListener(this@MainActivity)
        }
    }

    // 내비게이션 뷰 아이템 클릭 시
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuSetting -> {
//                setFragementView(SettingFragment())
            }
        }
        binding.dlMain.closeDrawer(GravityCompat.START)
        return false
    }

//    private fun setFragementView(fragment: Fragment) {
//        LogUtil.d("setFragementView : $fragment")
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.mainFrameLayout, fragment)
//            .commit()
//    }

    // 메인 상단 바 메뉴 선택 시
    private fun toggleDrawerLayout(drawerLayout: DrawerLayout) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START)
        } else {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        binding.apply {
            if (dlMain.isDrawerOpen(GravityCompat.START)) {
                dlMain.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }
}