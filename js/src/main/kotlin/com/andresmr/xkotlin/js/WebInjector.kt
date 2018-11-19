package com.andresmr.xkotlin.js

import com.andresmr.xkotlin.common.injector.BaseInjector
import com.andresmr.xkotlin.common.interactor.ObtainItemsInteractor
import com.andresmr.xkotlin.common.util.DateUtil
import com.andresmr.xkotlin.js.data.RepositoryImpl
import com.andresmr.xkotlin.js.util.DateUtilImpl

class WebInjector: BaseInjector() {
    override fun provideObtainItemsInteractor(): ObtainItemsInteractor {
        return ObtainItemsInteractor(RepositoryImpl())
    }

    override fun provideDateUtil(): DateUtil {
        return DateUtilImpl()
    }
}