package com.letslearntogether.madkart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.letslearntogether.madkart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityMainBinding

    //List - Recycler view
    private val adapter = ProductCardListAdapter()

    //private val viewModel: ProductListViewModel by viewModels()
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ProductViewModelProvider(ProductRepositoryAPI())
        )[ProductListViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recycle view
        binding.viewProductList.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter

        viewModel.viewState.observe(this){viewState ->
            updateUI(viewState)
        }

        viewModel.loadProductList()


    }

    private fun updateUI(viewState: ProductListViewState) {
        when(viewState){
            is ProductListViewState.Content -> {
                binding.errorView.isVisible = false
                binding.loadingView.isVisible = false
                binding.viewProductList.isVisible = true
                adapter.setData(viewState.productList)
            }

            ProductListViewState.Error -> {
                binding.viewProductList.isVisible = false
                binding.errorView.isVisible = true
                binding.loadingView.isVisible = false
            }

            ProductListViewState.Loading -> {
                binding.viewProductList.isVisible = false
                binding.errorView.isVisible = false
                binding.loadingView.isVisible = true
            }
        }

    }
}