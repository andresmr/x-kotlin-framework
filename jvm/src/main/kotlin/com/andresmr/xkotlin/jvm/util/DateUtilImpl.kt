package com.andresmr.xkotlin.jvm.util

import com.andresmr.xkotlin.common.util.DateUtil
import java.util.*

class DateUtilImpl : DateUtil {
    override fun getTimeStamp(): String {
        return Date().time.toString()
    }
}