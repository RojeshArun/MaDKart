package com.letslearntogether.madkart.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.letslearntogether.madkart.*
import com.letslearntogether.madkart.databinding.FragmentProductListBinding
import com.renarosantos.ecommerceapp.ProductCardListAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val adapter = ProductCardListAdapter(::onItemClicked)

    private fun onItemClicked(productCardData: ProductCardData) {
          //  findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment())
        Navigation.findNavController(binding.root).navigate(R.id.
        action_productListFragment_to_productDetailsFragment)
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ProductViewModelProvider(ProductRepositoryAPI())
        )[ProductListViewModel::class.java]
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
        viewModel.loadProductList()
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
    }

}