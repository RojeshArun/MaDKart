package com.letslearntogether.madkart.presentation.productdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.letslearntogether.madkart.databinding.FragmentProductDetailsBinding
import com.letslearntogether.madkart.presentation.productdetails.viewmodel.ProductDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Product Details screen
 **/
@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: ProductDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadProduct("1")
        viewModel.viewState.observe(viewLifecycleOwner){
            updateUi(it)
        }
    }

    private fun updateUi(viewState: ProductDetailViewState?) {
        when(viewState){
            is ProductDetailViewState.Content -> {
                with(binding){
                    loadingView.isVisible = false
                    val product = viewState.product
                    viewProductTitle.text = product.title
                    Glide.with(requireContext()).
                    load(product.imageUrl)
                        .into(viewProductImage)
                    viewPrice.text = product.price
                    viewFullDescription.text = product.fullDescription
                }
            }
            ProductDetailViewState.Error -> {
                binding.loadingView.isVisible = false
            }
            ProductDetailViewState.Loading -> {
                binding.loadingView.isVisible = true
            }
            else -> {}
        }
    }

}