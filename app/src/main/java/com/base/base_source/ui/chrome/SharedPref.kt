package com.base.base_source.ui.chrome

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.base.base_source.data.entities.SearchItem
import com.google.gson.Gson

@SuppressLint("ApplySharedPref")
class SharedPref {

    companion object {
        private const val SHARED_PREFERENCES = "chrome_app"
        private const val ACCOUNT = "account"

        private fun getSharePref(context: Context): SharedPreferences {
            return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        }

        private fun saveValueToKey(context: Context?, key: String, value: Boolean) {
            try {
                context?.let {
                    val editor = getSharePref(it).edit()
                    editor.putBoolean(key, value)
                    editor.commit()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        private fun saveValueToKey(context: Context?, key: String, value: Int) {
            try {
                context?.let {
                    val editor = getSharePref(it).edit()
                    editor.putInt(key, value)
                    editor.commit()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        private fun saveValueToKey(context: Context?, key: String, value: String) {
            try {
                context?.let {
                    val editor = getSharePref(it).edit()
                    editor.putString(key, value)
                    editor.commit()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun saveAcc(context: Context, account: Account) {
            val gson = Gson()
            val acc = gson.toJson(account)
            saveValueToKey(context, ACCOUNT, acc)
        }

        fun saveAcc2(context: Context, account: String) {
            saveValueToKey(context, ACCOUNT, account)
        }

        fun getSearchTrend(context: Context): List<SearchItem> {
            val account = getAcc(context)
            return account?.searchItem ?: emptyList()
        }

        fun getAcc(context: Context): Account? {
            val acc = getSharePref(context).getString(ACCOUNT, "")
            return try {
                if (!acc.isNullOrEmpty()) {
                    Gson().fromJson(acc, Account::class.java)
                } else {
                    Account("", ArrayList())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Account("",  ArrayList())
            }
        }
    }
}
