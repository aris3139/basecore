package com.base.base_source.ui.chrome

import com.base.base_source.data.entities.SearchItem


data class Account(
    val tenviettat: String,
    val searchItem: ArrayList<SearchItem> = arrayListOf()
)