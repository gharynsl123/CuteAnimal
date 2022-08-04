package com.example.wisataonline.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wisataonline.data.CatResponseItem
import com.example.wisataonline.data.network.ApiClient
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
    fun getDog(
        responseHandlerDog: (List<DogResponseItem>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        //Dog Response Handler
        ApiClient().getApiService().getCuteDog().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                responseHandlerDog(it)
            }, {
                error(it)
            })
    }

    fun getCat(
        responseHandlerCat: (List<CatResponseItem>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        //Cat Response Handler
        ApiClient().getApiService().getCuteCate().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                responseHandlerCat(it)
            }, {
                error(it)
            })
    }

    fun getDataDog() {
        isLoading.value = true
        getDog({
            isLoading.value = false
            dogResponse.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }

    fun getDataCat() {
        isLoading.value = true
        getCat({
            isLoading.value = false
            catResponse.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}

