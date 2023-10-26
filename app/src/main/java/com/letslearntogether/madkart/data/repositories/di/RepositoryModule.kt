package com.letslearntogether.madkart.data.repositories.di

import com.letslearntogether.madkart.data.repositories.api.APIClient
import com.letslearntogether.madkart.data.repositories.ProductRepository
import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.data.repositories.api.ProductRepositoryAPI
import com.letslearntogether.madkart.data.repositories.api.ProductService
import com.letslearntogether.madkart.data.repositories.api.WishListDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Step 4 Hilt - It Informs how to provide instances of certain types
@Module
//Step 11 Hilt
@InstallIn(SingletonComponent::class) // Used to define the visibility or scope
class RepositoryModule {

    //Step 5 Hilt - Create and provide instances of dependencies
    @Provides
    fun providesService(): ProductService = APIClient.getClient()


    //Step 6 Hilt
    @Provides
    fun providesProductRepository(
        productRepositoryAPI: ProductRepositoryAPI
    ): ProductRepository = productRepositoryAPI

    //Step 7 Hilt
    @Provides
    fun providesProductRepositoryAPI(
        service: ProductService
    ): ProductRepositoryAPI = ProductRepositoryAPI(service)

    @Provides
    fun providesWishListRepository(
        databaseRepository: WishListDatabaseRepository
    ): WishListRepository = databaseRepository


}