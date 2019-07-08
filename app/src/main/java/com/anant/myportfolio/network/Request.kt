package com.anant.myportfolio.network

import com.squareup.okhttp.Request

object Request {

    fun requestResume( url: String): Request{
        return Request.
            Builder().
                url(URL.resumeUrl).
            build()
    }
}