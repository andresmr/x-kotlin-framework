package com.andresmr.xkotlin.android.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)

fun <ITEM> RecyclerView.setUp(items: List<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              itemClick: ITEM.() -> Unit = {},
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)): ItemListAdapter<ITEM> {
    return ItemListAdapter(items, layoutResId, {
        bindHolder(it)
    }, {
        itemClick()
    }).apply {
        layoutManager = manager
        adapter = this
    }
}