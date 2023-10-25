package com.letslearntogether.madkart.presentation.productlist

import com.letslearntogether.madkart.domain.usecases.products.ProductCardData

sealed class ProductListViewState {
   object Error: ProductListViewState()

    object Loading: ProductListViewState()

    data class Content(val productList: List<ProductCardData>) : ProductListViewState()
}