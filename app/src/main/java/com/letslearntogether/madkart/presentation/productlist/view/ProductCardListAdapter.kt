package com.letslearntogether.madkart.presentation.productlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.letslearntogether.madkart.domain.entities.errorhandling.products.ProductCardData
import com.letslearntogether.madkart.R
import com.letslearntogether.madkart.databinding.ProductCardBinding

class ProductCardListAdapter(
    val onItemClicked: (ProductCardData) -> Unit,
    val onFavouriteItemClicked: (ProductCardData) -> Unit
) :
    RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {


    private var data: List<ProductCardData> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_card,
                parent, false
            )
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
        fun bind(productCard: ProductCardData) {
            val bind = ProductCardBinding.bind(itemView)
            itemView.setOnClickListener {
                onItemClicked.invoke(productCard)
            }
            bind.apply {
                viewProductName.text = productCard.title
                viewProductDescription.text = productCard.description
                productPrice.text = productCard.price

                viewWishlistIcon.setOnClickListener {
                    onFavouriteItemClicked.invoke(
                        productCard
                    )

                }
                viewWishlistIcon.setImageDrawable(
                    if (productCard.isFavourite) {
                        ResourcesCompat.getDrawable(
                            viewWishlistIcon.resources,
                            R.drawable.ic_baseline_favorite,
                            null
                        )
                    } else {
                        ResourcesCompat.getDrawable(
                            viewWishlistIcon.resources,
                            R.drawable.ic_baseline_favorite_disabled,
                            null
                        )
                    }
                )
                Glide.with(productImage)
                    .asBitmap()
                    .load(productCard.url)
                    .into(BitmapImageViewTarget(productImage))

            }
        }

    }
}