package com.example.wisataonline.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogResponse(

    @field:SerializedName("DogResponse")
    val dogResponse: List<DogResponseItem>? = null
) : Parcelable

@Parcelize
data class DogResponseItem(
//
    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null

) : Parcelable
