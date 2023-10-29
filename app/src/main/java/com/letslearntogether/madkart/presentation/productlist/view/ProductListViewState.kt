package com.letslearntogether.madkart.presentation.productlist.view

import com.letslearntogether.madkart.domain.usecases.products.ProductCardData

sealed class ProductListViewState {
    object Error : ProductListViewState()

    object Loading : ProductListViewState()

    data class Content(val productList: List<ProductCardData>) : ProductListViewState()
}

fun ProductListViewState.Content.updateFavoriteProduct(
    productId: String,
    isFavorite: Boolean
): ProductListViewState.Content {
    return ProductListViewState.Content(
        productList = this.productList.map { viewState ->
        if (viewState.productId == productId) {
            viewState.copy(isFavourite = isFavorite)
        } else {
            viewState
        }
    }
    )
}

