package com.raju.kitabeli.presentation.order

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.raju.kitabeli.bean.order.RequestBean
import com.raju.kitabeli.databinding.ActivityOrderBinding
import com.raju.kitabeli.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : BaseActivity() {
    private lateinit var binding: ActivityOrderBinding
    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTabs()
        initActions()
    }

    private fun initActions() {
        binding.iTopView.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setUpTabs() {
        binding.tlTabs.addTab(binding.tlTabs.newTab().setText("Pesanan Diproses"))
        binding.tlTabs.addTab(binding.tlTabs.newTab().setText("Pesanan Dikirim"))
        binding.tlTabs.addTab(binding.tlTabs.newTab().setText("Pesanan Tiba"))
        binding.tlTabs.addTab(binding.tlTabs.newTab().setText("Pesanan Dibatalkan"))

        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(OrderFragment())
        fragmentList.add(OrderFragment())
        fragmentList.add(OrderFragment())
        fragmentList.add(OrderFragment())

        val adapter: PagerAdapter = TabPagerAdapter(supportFragmentManager, fragmentList)

        binding.vpViewPager.adapter = adapter
        binding.vpViewPager.offscreenPageLimit = 4
        binding.vpViewPager.currentItem = 0
        val requestData = RequestBean("104913", "CONFIRMED",0,20)
        viewModel.sendRequestData(requestData)
        binding.vpViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tlTabs))
        binding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.vpViewPager.currentItem = tab.position
                setupRequestData(binding.vpViewPager.currentItem)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                binding.vpViewPager.currentItem = tab.position
                setupRequestData(binding.vpViewPager.currentItem)
            }
        })

    }

    private fun setupRequestData(position: Int) {
        var requestData:RequestBean? = null
        when (position) {
            0 -> {
                requestData = RequestBean("104913", "CONFIRMED",0,20)
                viewModel.sendRequestData(requestData)
            }
            1 -> {
                requestData = RequestBean("104913", "DISPATCHED",0,20)
                viewModel.sendRequestData(requestData)
            }
            2 -> {
                requestData = RequestBean("104913", "COMPLETED",0,20)
                viewModel.sendRequestData(requestData)
            }
            3 -> {
                requestData = RequestBean("104913", "CANCELLED",0,20)
                viewModel.sendRequestData(requestData)
            }
        }
    }

}