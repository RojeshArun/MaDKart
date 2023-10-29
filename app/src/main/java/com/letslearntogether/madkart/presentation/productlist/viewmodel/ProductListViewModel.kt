package com.letslearntogether.madkart.presentation.productlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.letslearntogether.madkart.data.repositories.ProductRepository
import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.domain.usecases.products.ProductCardData
import com.letslearntogether.madkart.domain.usecases.wishlist.AddOrRemoveFromWishListUseCase
import com.letslearntogether.madkart.domain.usecases.wishlist.IsProductInTheWishListUseCase
import com.letslearntogether.madkart.presentation.productlist.view.ProductListViewState
import com.letslearntogether.madkart.presentation.productlist.view.updateFavoriteProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Step 9 Hilt
@HiltViewModel  // @HiltViewModel is an annotation that enables Hilt to inject a ViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val wishListRepository: WishListRepository,
    private val isProductInWishListUseCase: IsProductInTheWishListUseCase,
    private val addOrRemoveFromWishListUseCase: AddOrRemoveFromWishListUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<ProductListViewState>()
    val viewState: LiveData<ProductListViewState>
        get() = _viewState


    fun loadProductList() {

        viewModelScope.launch {
            _viewState.postValue(ProductListViewState.Loading)
            // Data call to fetch products
            val productList = repository.getProductList()
            _viewState.postValue(
                ProductListViewState.Content(
                    productList.map {
                        ProductCardData(
                            it.title,
                            it.description,
                            "US $ ${it.price}",
                            it.url,
                            it.productId,
                            wishListRepository.isFavorite(it.productId)
                        )
                    }
                )
            )
        }
    }

    fun favoriteIconClicked(productId: String) {
        viewModelScope.launch {
            //Add or remove to fav
            addOrRemoveFromWishListUseCase.execute(productId)
            //Udpate the UI
            val currentViewState = _viewState.value
            (currentViewState as ProductListViewState.Content)?.let { content ->
                _viewState.postValue(
                    content.updateFavoriteProduct(
                        productId,
                        isProductInWishListUseCase.execute(productId)
                    )
                )
            }
        }

    }
}