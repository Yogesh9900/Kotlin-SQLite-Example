package com.test.pfbtest.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.test.pfbtest.model.ResponseData

import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

/**
 * Created by Yogesh Y. Nikam on 06/11/20.
 */
 class Repository {

    private val service = RetrofitClientInstance.getRetrofitInstance().create(
        APIService::class.java
    )


    private val serverData: MutableLiveData<ResponseData> = MutableLiveData<ResponseData>()
    fun getData(url:String?) : MutableLiveData<ResponseData> {

        //var patientResponseData :PatientResponseData = PatientResponseData()
        val call: Call<ResponseData> = service.getServerData(url)
        call.enqueue(object : Callback<ResponseData?> {
            override fun onResponse(
                call: Call<ResponseData?>,
                response: Response<ResponseData?>
            ) {
                serverData.value = response.body()
            }

            override fun onFailure(call: Call<ResponseData?>, t: Throwable) {
                //loginError.setValue("Something went wrong");
                Log.d("onFailure", t.toString())
            }
        })
        return serverData
    }



}