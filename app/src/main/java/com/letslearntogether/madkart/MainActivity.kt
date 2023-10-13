package com.letslearntogether.madkart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.letslearntogether.madkart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityMainBinding

    //List - Recycler view
    private val adapter = ProductCardListAdapter()

    private val viewModel: ProductListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recycle view
        binding.viewProductList.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter

        viewModel.loadProductList()
        viewModel.viewState.observe(this){viewState ->
            updateUI(viewState)
        }

    //    updateUI(ProductListViewState.Loading)
    /*    updateUI(ProductListViewState.Content((1..3).map {
            ProductCardData("Playstation $it", "This is a nice console! Check it out", "200 US$")
        }))*/




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