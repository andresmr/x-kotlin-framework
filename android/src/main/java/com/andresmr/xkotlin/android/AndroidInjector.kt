package com.andresmr.xkotlin.android

import com.andresmr.xkotlin.android.data.RepositoryImpl
import com.andresmr.xkotlin.common.injector.BaseInjector
import com.andresmr.xkotlin.common.interactor.ObtainItemsInteractor
import com.andresmr.xkotlin.common.util.DateUtil
import com.andresmr.xkotlin.jvm.util.DateUtilImpl

class AndroidInjector : BaseInjector() {
    override fun provideObtainItemsInteractor(): ObtainItemsInteractor {
        return ObtainItemsInteractor(RepositoryImpl())
    }

    override fun provideDateUtil(): DateUtil {
        return DateUtilImpl()
    }
}