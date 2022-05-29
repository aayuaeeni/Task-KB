package com.raju.kitabeli.presentation.order.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.kitabeli.bean.order.OrdersResponseDTOBean
import com.raju.kitabeli.databinding.FooterLayoutBinding
import com.raju.kitabeli.databinding.OrderMainItemBinding
import com.raju.utils.formatDate

class OrderMainListAdapter(
    var orderList: List<OrdersResponseDTOBean>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val FOOTER = 1
    private val ITEM = 0
    private lateinit var binding: OrderMainItemBinding


    inner class ItemViewHolder(  binding: OrderMainItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.rvItems.setHasFixedSize(true)
            binding.rvItems.layoutManager =
                LinearLayoutManager(binding.rvItems.context, LinearLayoutManager.VERTICAL, false)
            binding.rvItems.isNestedScrollingEnabled = true
        }
    }
    inner class FooterViewHolder( binding: FooterLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            binding = OrderMainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemViewHolder(binding)
        } else {
            val binding = FooterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            FooterViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == orderList.size) {
            FOOTER
        } else ITEM
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder.itemViewType == ITEM) {
            val order = orderList[position]
            binding.tvOrderDate.formatDate(order.createdAt)
            binding.tvOrderId.text = "Pesanan ${order.orderId}"
            val orderItemListAdapter = OrderItemListAdapter(order.orderItems,order.status)
            binding.rvItems.adapter = orderItemListAdapter
        }
        else if (viewHolder.itemViewType == FOOTER){

        }
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        if (orderList.isEmpty()) {
            return 0
        }
        return orderList.size
    }
}