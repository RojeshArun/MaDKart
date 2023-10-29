package com.letslearntogether.madkart.domain.usecases.wishlist

import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.data.repositories.sharedprefs.WishlistSharedPrefRepo
import javax.inject.Inject

class IsProductInTheWishListUseCase @Inject constructor(
    private val wishListRepository: WishListRepository
) {
    suspend fun execute(productId: String): Boolean =
        wishListRepository.isFavorite(productId)
}