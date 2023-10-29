package com.letslearntogether.madkart.data.repositories.di

import android.content.Context
import androidx.room.Room
import com.letslearntogether.madkart.data.repositories.api.APIClient
import com.letslearntogether.madkart.data.repositories.ProductRepository
import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.data.repositories.api.ProductRepositoryAPI
import com.letslearntogether.madkart.data.repositories.api.ProductService
import com.letslearntogether.madkart.data.repositories.api.WishListDatabaseRepository
import com.letslearntogether.madkart.data.repositories.database.AppDatabase
import com.letslearntogether.madkart.data.repositories.database.WishListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // Used to define the visibility or scope
class RepositoryModule {

    @Provides
    fun providesService(): ProductService = APIClient.getClient()


    @Provides
    fun providesProductRepository(
        productRepositoryAPI: ProductRepositoryAPI
    ): ProductRepository = productRepositoryAPI

    @Provides
    fun providesProductRepositoryAPI(
        service: ProductService
    ): ProductRepositoryAPI = ProductRepositoryAPI(service)

    @Provides
    fun providesWishListRepository(
        databaseRepository: WishListDatabaseRepository
    ): WishListRepository = databaseRepository

    @Provides
    fun providesWishListDatabaseRepository(
        databaseDao: WishListDao
    ): WishListDatabaseRepository {
        return WishListDatabaseRepository(databaseDao)
    }

    @Provides
    fun providesWishListDao(
        @ApplicationContext context: Context
    ): WishListDao {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ecommerce-mad-database"
        ).build()
        return db.wishListDao()
    }

}