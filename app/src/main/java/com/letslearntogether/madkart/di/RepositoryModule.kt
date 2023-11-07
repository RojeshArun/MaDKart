package com.letslearntogether.madkart.di

import android.content.Context
import androidx.room.Room
import com.letslearntogether.madkart.data.network.APIClient
import com.letslearntogether.madkart.domain.interfaces.repositories.ProductRepository
import com.letslearntogether.madkart.domain.interfaces.repositories.WishListRepository
import com.letslearntogether.madkart.data.repositories.ProductRepositoryImpl
import com.letslearntogether.madkart.data.network.ProductService
import com.letslearntogether.madkart.data.network.WishListDatabaseRepository
import com.letslearntogether.madkart.data.persistentstorages.database.MadKartDatabase
import com.letslearntogether.madkart.data.persistentstorages.database.dao.WishListDao
import com.letslearntogether.madkart.data.persistentstorages.sharedprefs.WishlistSharedPrefRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class) // Used to define the visibility or scope
class RepositoryModule {

    @Provides
    fun providesService(): ProductService = APIClient.getClient()


    @Provides
    fun providesProductRepository(
        productRepositoryAPI: ProductRepositoryImpl
    ): ProductRepository = productRepositoryAPI

    @Provides
    fun providesProductRepositoryAPI(
        service: ProductService
    ): ProductRepositoryImpl =
        ProductRepositoryImpl(service)

    //TO Explain Switching from db to shared prefs ******
    // Room db
/*
    @Provides
    fun providesWishListRepository(
        databaseRepository: WishListDatabaseRepository
    ): WishListRepository = databaseRepository
*/

    //Share prefs
    @Provides
    fun providesWishListRepository(
        sharedPrefRepo: WishlistSharedPrefRepo
    ): WishListRepository = sharedPrefRepo

    /* //TODO datastore
    fun providesWishListRepository(
        preferenceDataStore:WishlistSharedPrefRepo
    ):WishListRepository = preferenceDataStore*/


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
            MadKartDatabase::class.java,
            "ecommerce-mad-database"
        ).build()
        return db.wishListDao()
    }

    @Provides
    fun providesWishListSharedPrefRepo(
        @ApplicationContext context: Context
    ): WishlistSharedPrefRepo {
        return WishlistSharedPrefRepo(context)
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO


}