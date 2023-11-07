package com.letslearntogether.madkart.domain.entities.errorhandling.products

data class ProductCardData(
    val title: String,
    val description: String,
    val price: String,
    val url: String,
    val productId: String,
    var isFavourite: Boolean
)