package com.letslearntogether.madkart.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.letslearntogether.madkart.domain.interfaces.repositories.WishListRepository

class WishListDatastoreImpl(context: Context) : WishListRepository {

    companion object {
        const val PREFS_DATASTORE_WISHLIST = "com.letslearntogether.madkart.datastore.wishlist"
        //val KEY_FAVORITES_SET = <List<FavouriteProductEntity>>("my_list_preference")

    }

    private val Context.dataStore: DataStore<Preferences>
            by preferencesDataStore(name = PREFS_DATASTORE_WISHLIST)
    private val dataStore = context.dataStore

    /*val myListPreference: Flow<List<String>> = dataStore.data.map { preferences ->
        preferences[KEY_FAVORITES_SET] ?: emptyList()
    }*/

    override suspend fun isFavorite(productId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun addToWishList(productId: String) {
        dataStore.edit { prefs ->
            /*val favorites = getStringSet(WishlistSharedPrefRepo.KEY_FAVORITES_SET, emptySet())
            mutableSetOf<String>().run {
                this.addAll(favorites!!.toList())
                this.add(productId)
                prefs.edit().putStringSet(WishlistSharedPrefRepo.KEY_FAVORITES_SET, this).apply()
            }*/
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        TODO("Not yet implemented")
    }
}