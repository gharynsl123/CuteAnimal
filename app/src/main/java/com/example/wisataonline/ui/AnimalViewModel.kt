package com.example.wisataonline.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wisataonline.data.CatResponse
import com.example.wisataonline.data.CatResponseItem
import com.example.wisataonline.data.network.ApiClient
import com.example.wisataonline.data.response.DogResponse
import com.example.wisataonline.data.response.DogResponseItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AnimalViewModel : ViewModel() {

    //response
    val catResponse = MutableLiveData<List<CatResponseItem>>()
    val dogResponse = MutableLiveData<List<DogResponseItem>>()

    //Checking
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    //Cat Response and Error function
    fun getCatAndDog(
        responseHandlerCat: (List<CatResponseItem>) -> Unit,
        responseHandlerDog: (List<DogResponseItem>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        //Cat Response Handler
        ApiClient().getApiService().getCuteCate().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                responseHandlerCat(it as List<CatResponseItem>)
            }, {
                error(it)
            })
        //Dog Response Handler
        ApiClient().getApiService().getCuteDog().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                responseHandlerDog(it as List<DogResponseItem>)
            }, {
                error(it)
            })
    }

    fun getDataCatAndDog() {
        isLoading.value = true
        getCatAndDog({
            isLoading.value = false
            catResponse.value = it
        }, {
            isLoading.value = true
            dogResponse.value = it
        }, {
            isLoading.value = true
            isError.value = it
        })
    }
}