package com.letslearntogether.madkart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.letslearntogether.madkart.databinding.ProductCardBinding

class ProductCardListAdapter(val onItemClicked: (ProductCardData) -> Unit)
    : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {


    private var data: List<ProductCardData> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card,
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<ProductCardData>) {
        this.data = productList
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productCardViewState: ProductCardData) {
            val bind = ProductCardBinding.bind(itemView)
            itemView.setOnClickListener {
                onItemClicked(productCardViewState)
            }
            bind.apply {
                viewProductName.text = productCardViewState.title
                viewProductDescription.text = productCardViewState.description
                productPrice.text = productCardViewState.price
                Glide.with(productImage)
                    .asBitmap()
                    .load(productCardViewState.url)
                    .into(BitmapImageViewTarget(productImage))
            }
        }

    }
}