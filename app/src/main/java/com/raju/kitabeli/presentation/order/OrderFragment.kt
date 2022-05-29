package com.raju.kitabeli.presentation.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.raju.domain.model.order.OrderItemContent
import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.kitabeli.bean.order.OrdersResponseDTOBean
import com.raju.kitabeli.databinding.FragmentOrderBinding
import com.raju.kitabeli.presentation.base.BaseFragment
import com.raju.kitabeli.presentation.order.adapter.OrderMainListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFragment : BaseFragment() {
    private lateinit var binding: FragmentOrderBinding
    private val viewModel: OrderViewModel by viewModels()
    private val sharedVM: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        initObservers()
    }

    private fun setViews() {
        binding.rvOrder.setHasFixedSize(true)
        binding.rvOrder.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvOrder.isNestedScrollingEnabled = true
    }

    private fun initObservers() {
        sharedVM.requestLD.observe(viewLifecycleOwner) {
            binding.iLoadedView.rlProgressContainer.visibility = View.VISIBLE
            viewModel.onViewCreated(it)
        }

        viewModel.orderListLD.observe(viewLifecycleOwner) {
            setupAdapter(it)

        }
        viewModel.noItemLD.observe(viewLifecycleOwner) {
            if (it){
                binding.tvNoItem.visibility = View.GONE
            }else{
                binding.tvNoItem.visibility = View.VISIBLE
                binding.rvOrder.visibility = View.GONE
                binding.iLoadedView.rlProgressContainer.visibility = View.GONE
            }
        }
    }

    private fun setupAdapter(it: List<OrdersResponseDTOBean>?) {
        it?.run {
            val orderMainListAdapter = OrderMainListAdapter(this)
            binding.rvOrder.adapter = orderMainListAdapter
            binding.iLoadedView.rlProgressContainer.visibility = View.GONE
        }
    }
}