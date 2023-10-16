package com.letslearntogether.madkart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.letslearntogether.madkart.databinding.ProductCardBinding

class ProductCardListAdapter : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {

    private var data: List<ProductCardData> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        )
    }

    override fun getItemCount(): Int {
        //Step 5.1
        return data.size
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