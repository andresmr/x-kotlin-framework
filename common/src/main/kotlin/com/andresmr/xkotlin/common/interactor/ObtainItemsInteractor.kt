package com.andresmr.xkotlin.common.interactor

import com.andresmr.xkotlin.common.data.Repository
import com.andresmr.xkotlin.common.entity.Item

class ObtainItemsInteractor(private val repository: Repository) {

    fun obtain(onSuccess: (items: List<Item>) -> Unit, onError: (message: String) -> Unit) {
        repository.getItems({ items -> onSuccess(items) }, { message -> onError(message) })
    }

    fun addItem(item: Item, onSuccess: () -> Unit, onError: (message: String) -> Unit) {
        repository.add(item, { onSuccess() }, { message -> onError(message) })
    }
}