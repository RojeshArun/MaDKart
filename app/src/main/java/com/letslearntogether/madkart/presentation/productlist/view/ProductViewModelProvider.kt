package com.letslearntogether.madkart.presentation.productlist.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.letslearntogether.madkart.data.repositories.ProductRepository

class ProductViewModelProvider(val repository: ProductRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ProductRepository::class.java).newInstance(repository)
    }
}