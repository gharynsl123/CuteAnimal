package com.example.wisataonline.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogResponse(

    @field:SerializedName("DogResponse")
    val dogResponse: List<DogResponseItem?>? = null
) : Parcelable

@Parcelize
data class BreedsItem(

    @field:SerializedName("life_span")
    val lifeSpan: String? = null,

    @field:SerializedName("temperament")
    val temperament: String? = null,

    @field:SerializedName("origin")
    val origin: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("reference_image_id")
    val referenceImageId: String? = null,

    @field:SerializedName("breed_group")
    val breedGroup: String? = null,

    @field:SerializedName("country_code")
    val countryCode: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("history")
    val history: String? = null
) : Parcelable

@Parcelize
data class DogResponseItem(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("breeds")
    val breeds: List<BreedsItem?>? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : Parcelable
