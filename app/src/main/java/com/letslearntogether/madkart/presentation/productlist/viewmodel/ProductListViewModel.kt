package com.letslearntogether.madkart.presentation.productlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.letslearntogether.madkart.data.repositories.ProductRepository
import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.domain.usecases.products.ProductCardData
import com.letslearntogether.madkart.presentation.productlist.view.ProductListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Step 9 Hilt
@HiltViewModel  // @HiltViewModel is an annotation that enables Hilt to inject a ViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val wishListRepository: WishListRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<ProductListViewState>()
    val viewState: LiveData<ProductListViewState>
        get() = _viewState


    fun loadProductList() {

        viewModelScope.launch {
            _viewState.postValue(ProductListViewState.Loading)
            // Data call to fetch products
            //Step 4
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
}