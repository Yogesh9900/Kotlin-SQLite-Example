package com.test.pfbtest.retrofit

import com.test.pfbtest.model.ResponseData
import retrofit2.http.*
import retrofit2.Call

/**
 * Created by Yogesh Y. Nikam on 06/11/20.
 */
interface APIService {

    @Headers("Content-Type: application/json")

    @GET
    fun getServerData(@Url url : String?): Call<ResponseData>


}