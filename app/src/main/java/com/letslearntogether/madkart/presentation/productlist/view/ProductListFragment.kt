package com.letslearntogether.madkart.presentation.productlist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.letslearntogether.madkart.*
import com.letslearntogether.madkart.databinding.FragmentProductListBinding
import com.letslearntogether.madkart.domain.entities.errorhandling.products.ProductCardData
import com.letslearntogether.madkart.presentation.productlist.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val adapter = ProductCardListAdapter(
        ::onItemClicked,
        ::onFavoriteIconClicked
    )
    private val viewModel: ProductListViewModel by viewModels()

    private fun onItemClicked(productCardData: ProductCardData) {
        //  findNavController().navigate(ProductListFragmentDirections.
        //  actionProductListFragmentToProductDetailsFragment())
        Navigation.findNavController(binding.root).navigate(
            R.id.action_productListFragment_to_productDetailsFragment
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewProductList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            updateUI(viewState)
        }
    }

    private fun onFavoriteIconClicked(viewData: ProductCardData){
        viewModel.favoriteIconClicked(viewData.productId)
    }

    private fun updateUI(viewState: ProductListViewState) {
        binding.apply {
            when (viewState) {
                is ProductListViewState.Content -> {
                    viewProductList.isVisible = true
                    errorView.isVisible = false
                    loadingView.isVisible = false
                    adapter.setData(viewState.productList)
                }
                ProductListViewState.Error -> {
                    viewProductList.isVisible = false
                    errorView.isVisible = true
                    loadingView.isVisible = false
                }
                ProductListViewState.Loading -> {

                    viewProductList.isVisible = false
                    errorView.isVisible = false
                    loadingView.isVisible = true
                }
            }
        }
        adapter.notifyDataSetChanged()
    }

}