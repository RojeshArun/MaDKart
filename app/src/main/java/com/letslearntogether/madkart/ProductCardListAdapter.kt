package com.letslearntogether.madkart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.letslearntogether.madkart.databinding.ProductCardBinding

class ProductCardListAdapter : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {

    private var data: List<ProductCardData> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun setData(data:List<ProductCardData>) {
        this.data = data
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(productCardViewState: ProductCardData){
            val bind = ProductCardBinding.bind(itemView)
            bind.viewProductName.text = productCardViewState.title
            bind.viewProductDescription.text = productCardViewState.description
            bind.productPrice.text = productCardViewState.price
        }

    }
}