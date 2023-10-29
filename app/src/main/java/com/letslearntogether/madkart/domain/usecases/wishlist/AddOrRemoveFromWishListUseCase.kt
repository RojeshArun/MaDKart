package com.letslearntogether.madkart.domain.usecases.wishlist

import com.letslearntogether.madkart.data.repositories.WishListRepository
import javax.inject.Inject

class AddOrRemoveFromWishListUseCase @Inject constructor(
    private val isProductInTheWishListUseCase: IsProductInTheWishListUseCase,
    private val wishListRepository: WishListRepository
) {
    suspend fun execute(productId: String) {
        if (isProductInTheWishListUseCase.execute(productId)) {
            wishListRepository.addToWishList(productId)
        } else {
            wishListRepository.removeFromWishList(productId)
        }
    }

}