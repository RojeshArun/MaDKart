package com.letslearntogether.madkart.data.repositories.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import com.letslearntogether.madkart.data.repositories.WishListRepository

class WishlistSharedPrefRepo(context: Context): WishListRepository {

    companion object {
        const val SHARED_PREFS_FILE_WISHLIST = "com.letslearntogether.madkart.wishlist"
        const val KEY_FAVORITES_SET = "KEY_FAVORITES_SET"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_FILE_WISHLIST, Context.MODE_PRIVATE
    )

    override suspend fun isFavorite(productId: String): Boolean {
        with(sharedPref){
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            return favorites!!.contains(productId)
        }
    }

    override suspend fun addToWishList(productId: String) {
        with(sharedPref) {
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            mutableSetOf<String>().run {
                this.addAll(favorites!!.toList())
                this.add(productId)
                sharedPref.edit().putStringSet(KEY_FAVORITES_SET, this).apply()
            }
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        with(sharedPref) {
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            mutableSetOf<String>().run {
                this.addAll(favorites!!.toList())
                this.remove(productId)
                sharedPref.edit().putStringSet(KEY_FAVORITES_SET, this).apply()
            }
        }
    }
}