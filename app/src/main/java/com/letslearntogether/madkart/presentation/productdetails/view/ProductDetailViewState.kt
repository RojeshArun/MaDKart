package com.letslearntogether.madkart.presentation.productdetails.view

import com.letslearntogether.madkart.domain.entities.errorhandling.products.ProductDetails

sealed class ProductDetailViewState {

    object Loading : ProductDetailViewState()

    data class Content(val product: ProductDetails) : ProductDetailViewState()

    object Error : ProductDetailViewState()

}