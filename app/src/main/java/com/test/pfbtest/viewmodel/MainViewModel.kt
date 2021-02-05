package com.test.pfbtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.pfbtest.model.ResponseData
import com.test.pfbtest.retrofit.Repository

/**
 * Created by Yogesh Y. Nikam on 03/02/21.
 */
class MainViewModel: ViewModel() {

    var mutableData: MutableLiveData<ResponseData>? = null
    private val repository: Repository

    init {
        repository = Repository()
    }

    fun getData(url: String?) {

        if (mutableData != null) {
            return
        }
        mutableData = repository.getData(
            url = url
        )
    }

}