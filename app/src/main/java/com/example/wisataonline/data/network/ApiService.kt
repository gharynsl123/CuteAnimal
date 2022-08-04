package com.example.wisataonline.data.network

import com.example.wisataonline.data.CatResponse
import com.example.wisataonline.data.response.DogResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("imageCat")
    fun getCuteCate(): Flowable<List<CatResponse>>


    @GET("imageDog")
    fun getCuteDog(): Flowable<List<DogResponse>>
}