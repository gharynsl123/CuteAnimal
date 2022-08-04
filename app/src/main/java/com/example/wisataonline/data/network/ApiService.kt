package com.example.wisataonline.data.network

import com.example.wisataonline.data.CatResponseItem
import com.example.wisataonline.data.response.DogResponseItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("imageCat")
    fun getCuteCate(): Flowable<List<CatResponseItem>>


    @GET("imageDog")
    fun getCuteDog(): Flowable<List<DogResponseItem>>
}