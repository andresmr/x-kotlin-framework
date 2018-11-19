package com.andresmr.xkotlin.js.data

import com.andresmr.xkotlin.common.data.Repository
import com.andresmr.xkotlin.common.entity.Item

class RepositoryImpl: Repository {
    private val listItems = ArrayList<Item>()

    override fun add(item: Item, onSuccess: () -> Unit, onError: (message: String) -> Unit) {
        listItems.add(item)
        onSuccess()
    }

    override fun getItems(onSuccess: (items: List<Item>) -> Unit, onError: (message: String) -> Unit) {

        onSuccess(listItems)    }

}