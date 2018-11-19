package com.andresmr.xkotlin.common.data

import com.andresmr.xkotlin.common.entity.Item

interface Repository {

    fun add(item: Item, onSuccess: () -> Unit, onError: (message: String) -> Unit)

    fun getItems(onSuccess: (items: List<Item>) -> Unit, onError: (message: String) -> Unit)
}