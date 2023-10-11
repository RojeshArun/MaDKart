package com.letslearntogether.madkart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.letslearntogether.madkart.databinding.ProductCardBinding

class ProductCardListAdapter : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val bind = ProductCardBinding.bind(itemView)
            bind.viewProductName.text = "iPhone 15"
            bind.viewProductDescription.text = "Same as iPhone 14 :)"
            bind.productPrice.text = "1599$"
        }

    }
}