package com.andresmr.xkotlin.common.injector

import com.andresmr.xkotlin.common.interactor.ObtainItemsInteractor
import com.andresmr.xkotlin.common.presenter.ItemListPresenter
import com.andresmr.xkotlin.common.util.DateUtil

abstract class BaseInjector {
    fun provideItemListPresenter(view : ItemListPresenter.View) : ItemListPresenter {
        return ItemListPresenter(view, provideObtainItemsInteractor(), provideDateUtil())
    }

    abstract fun provideObtainItemsInteractor() : ObtainItemsInteractor

    abstract fun provideDateUtil() : DateUtil
}