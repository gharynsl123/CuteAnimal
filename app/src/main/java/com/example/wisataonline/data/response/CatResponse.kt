package com.example.wisataonline.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatResponse(

    @field:SerializedName("CatResponse")
    val catResponse: List<CatResponseItem?>? = null
) : Parcelable

@Parcelize
data class CatResponseItem(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : Parcelable
