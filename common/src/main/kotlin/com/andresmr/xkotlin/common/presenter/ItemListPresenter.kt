package com.andresmr.xkotlin.common.presenter

import com.andresmr.xkotlin.common.entity.Item
import com.andresmr.xkotlin.common.interactor.ObtainItemsInteractor
import com.andresmr.xkotlin.common.ui.model.ItemUiModel
import com.andresmr.xkotlin.common.util.DateUtil

class ItemListPresenter(private val view: View, private val obtainItemsInteractor: ObtainItemsInteractor, private val dateUtil: DateUtil) {

    fun onStart() {
        view.showLoading()
        retrieveItems()
    }

    fun retrieveItems() {
        obtainItemsInteractor.obtain(
                { items ->
                    val itemUiModels = ArrayList<ItemUiModel>()
                    items.mapTo(itemUiModels) { ItemUiModel(it.name, it.description) }
                    view.showStoredItems(itemUiModels)
                    view.hideLoading()
                },
                {
                    message ->
                    view.hideLoading()
                })
    }

    fun onItemSelected(item: ItemUiModel) {
        view.showItemSelected(item)
    }

    fun onAddItems() {
        val newItem = Item("New registry", dateUtil.getTimeStamp())
        obtainItemsInteractor.addItem(newItem,
                {
                    view.showItemAdded()
                },
                {
                    message ->
                })
    }

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showStoredItems(items: List<ItemUiModel>)
        fun showItemSelected(item: ItemUiModel)
        fun showItemAdded()
    }
}