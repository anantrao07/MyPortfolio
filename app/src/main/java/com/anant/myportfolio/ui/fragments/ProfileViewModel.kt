package com.anant.myportfolio.ui.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anant.myportfolio.data.resume.Resume
import com.anant.myportfolio.network.OkHttpClient
import com.anant.myportfolio.network.Request.requestResume
import com.anant.myportfolio.network.URL.resumeUrl
import com.google.gson.Gson
import com.squareup.okhttp.Callback
import com.squareup.okhttp.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class ProfileViewModel : ViewModel() {

    val resumeFeed: MutableLiveData<Resume>? by lazy {
        MutableLiveData<Resume>()
    }

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    fun doGetResume(): MutableLiveData<Resume>? {
        val client = OkHttpClient.okHttpClient
        val request = requestResume(resumeUrl)
        uiScope.launch {

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(request: com.squareup.okhttp.Request?, e: IOException?) {
                }

                override fun onResponse(response: Response?) {
                    val responseData = response?.body()?.string()
                    val resume: Resume = Gson().fromJson(responseData, Resume::class.java)
                    resumeFeed?.postValue(resume)
                    Log.d("response", resume.basics?.name)
                }
            })
        }
        return resumeFeed
    }
}
