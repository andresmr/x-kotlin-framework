package com.andresmr.xkotlin.android.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.andresmr.xkotlin.android.AndroidInjector
import com.andresmr.xkotlin.android.R.layout.activity_main
import com.andresmr.xkotlin.android.R.layout.item_layout
import com.andresmr.xkotlin.common.presenter.ItemListPresenter
import com.andresmr.xkotlin.common.ui.model.ItemUiModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MainView : AppCompatActivity(), ItemListPresenter.View {

    private val injector = AndroidInjector()
    private val presenter = injector.provideItemListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        setListeners()
        presenter.onStart()
    }

    private fun setListeners() {
        swipeRefresh.setOnRefreshListener { presenter.retrieveItems() }
        addItem.setOnClickListener { presenter.onAddItems() }
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showStoredItems(items: List<ItemUiModel>) {
        recyclerView.setUp(items, item_layout, {
            title.text = it.name
            description.text = it.description
        }, {
            presenter.onItemSelected(this)
        })
    }

    override fun showItemSelected(item: ItemUiModel) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }

    override fun showItemAdded() {
        Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
    }
}