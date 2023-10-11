package com.letslearntogether.madkart

sealed class ProductListViewState {
   object Error: ProductListViewState()

    object Loading: ProductListViewState()

    data class Content(val productList: List<ProductCardData>) : ProductListViewState()
}