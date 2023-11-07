package com.letslearntogether.madkart.domain.usecases.wishlist

import android.util.Log
import com.letslearntogether.madkart.domain.interfaces.repositories.WishListRepository
import javax.inject.Inject

class AddOrRemoveFromWishListUseCase @Inject constructor(
    private val isProductInTheWishListUseCase: IsProductInTheWishListUseCase,
    private val wishListRepository: WishListRepository
) {
    suspend fun execute(productId: String) {
        if (!isProductInTheWishListUseCase.execute(productId)) {
            Log.e("Add Use case","Product added")
            wishListRepository.addToWishList(productId)
        } else {
            wishListRepository.removeFromWishList(productId)
            Log.e("Add Use case","Product Removed")
        }
    }

}