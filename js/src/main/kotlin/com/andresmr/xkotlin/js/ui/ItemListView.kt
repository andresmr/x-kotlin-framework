package com.andresmr.xkotlin.js.ui

import com.andresmr.xkotlin.common.presenter.ItemListPresenter
import com.andresmr.xkotlin.common.ui.model.ItemUiModel
import com.andresmr.xkotlin.js.WebInjector
import kotlin.browser.document

class ItemListView : ItemListPresenter.View {
    private val injector = WebInjector()
    private val presenter = injector.provideItemListPresenter(this)

    init {
        setListeners()
        presenter.onStart()
    }

    private fun setListeners() {
        val refresh = document.getElementById("refresh")
        refresh!!.addEventListener("click", { presenter.retrieveItems() })

        val addRegistry = document.getElementById("addRegistry")
        addRegistry!!.addEventListener("click", {presenter.onAddItems()})
    }

    override fun showStoredItems(items: List<ItemUiModel>) {
        val list = document.getElementById("itemsList")
        list!!.innerHTML = ""

        for (item in items) {
            val listItem = document.createElement("button")
            listItem.setAttribute("class", "list-group-item")
            listItem.setAttribute("class", "list-group-item-action")
            listItem.textContent = "${item.name} - ${item.description}"
            listItem.addEventListener("click", { presenter.onItemSelected(item) })
            list.appendChild(listItem)
        }
    }

    override fun showItemSelected(item: ItemUiModel) {
        val selectedItem = document.getElementById("selectedItem")
        selectedItem!!.innerHTML = "You have selected ${item.name}"
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showItemAdded() {
        val selectedItem = document.getElementById("selectedItem")
        selectedItem!!.innerHTML = "New item added"
    }
}