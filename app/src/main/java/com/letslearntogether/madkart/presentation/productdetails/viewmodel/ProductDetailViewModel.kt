package com.letslearntogether.madkart.presentation.productdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.letslearntogether.madkart.domain.interfaces.repositories.ProductRepository
import com.letslearntogether.madkart.presentation.productdetails.view.ProductDetailViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val repository: ProductRepository
):ViewModel(){

    private val _viewState = MutableLiveData<ProductDetailViewState>()
    val viewState: LiveData<ProductDetailViewState>
        get() = _viewState

    fun loadProduct(productId: String){
        viewModelScope.launch {
            _viewState.postValue(ProductDetailViewState.Loading)
            // Data call to fetch products
            val productDetails = repository.getProductDetails(productId)
            _viewState.postValue(ProductDetailViewState.Content(productDetails))
        }
    }
}