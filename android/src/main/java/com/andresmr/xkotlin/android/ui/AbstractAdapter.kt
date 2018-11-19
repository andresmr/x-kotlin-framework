package com.andresmr.xkotlin.android.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class AbstractAdapter<ITEM> constructor(protected var itemList: List<ITEM>,
                                                 private val layoutResId: Int)
    : RecyclerView.Adapter<AbstractAdapter.Holder>() {

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent inflate layoutResId
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }
        return viewHolder
    }

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item)
    }

    protected open fun View.bind(item: ITEM) {
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}