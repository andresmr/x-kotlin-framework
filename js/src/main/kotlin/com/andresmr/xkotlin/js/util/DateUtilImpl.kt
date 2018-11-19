package com.andresmr.xkotlin.js.util

import com.andresmr.xkotlin.common.util.DateUtil
import kotlin.js.Date

class DateUtilImpl : DateUtil {
    override fun getTimeStamp(): String {
        return Date().getTime().toString()
    }
}