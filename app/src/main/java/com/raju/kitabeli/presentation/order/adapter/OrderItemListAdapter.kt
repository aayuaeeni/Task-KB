package com.raju.kitabeli.presentation.order.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.raju.domain.model.order.OrderItemContent
import com.raju.kitabeli.R
import com.raju.kitabeli.bean.order.OrderItemBean
import com.raju.kitabeli.databinding.OrderChildItemBinding
import com.raju.utils.loadImageFromUrl

class OrderItemListAdapter(
    var itemList: List<OrderItemBean>,
    var status : String
) : RecyclerView.Adapter<OrderItemListAdapter.ViewHolder>() {
    private lateinit var binding: OrderChildItemBinding
    inner class ViewHolder(binding: OrderChildItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = OrderChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        binding.ivImage.loadImageFromUrl(item.itemImgUrl, R.drawable.kitabeli)
        binding.tvName.text = item.itemName
        binding.tvPrice.text = "Rp. ${item.price}"
        binding.tvQty.text = "Jumlah: ${item.quantity}"

        when (status) {
            "CONFIRMED" -> {
                binding.tvStatus.visibility = View.GONE
                binding.tvType.visibility = View.GONE
            }
            "DISPATCHED" -> {
                binding.tvStatus.visibility = View.VISIBLE
                binding.tvStatus.setBackgroundResource(R.drawable.bg_rounded_green)
                binding.tvStatus.setTextColor(Color.parseColor("#006400"))
                binding.tvType.visibility = View.GONE
                binding.tvStatus.text = "Produk sedang disiapkan"
            }
            "COMPLETED" -> {
                binding.tvStatus.visibility = View.VISIBLE
                binding.tvStatus.setBackgroundResource(R.drawable.bg_rounded_green)
                binding.tvStatus.setTextColor(Color.parseColor("#006400"))
                binding.tvType.visibility = View.GONE
                binding.tvStatus.text = "Produk terkirim"
            }
            "CANCELLED" -> {
                binding.tvStatus.visibility = View.VISIBLE
                binding.tvStatus.setBackgroundResource(R.drawable.bg_rounded)
                binding.tvStatus.setTextColor(Color.parseColor("#FE0053"))
                binding.tvType.visibility = View.VISIBLE
                binding.tvStatus.text = "Pengiriman dibatalkan"

            }
        }

        binding.rlContainer.setOnClickListener {
            // Just for info
            Toast.makeText(binding.rlContainer.context, "$status ${item.itemName}", Toast.LENGTH_LONG).show()
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    interface OrderFragmentListener {
        fun onItemClicked(status: String, item:OrderItemContent)
    }
}
