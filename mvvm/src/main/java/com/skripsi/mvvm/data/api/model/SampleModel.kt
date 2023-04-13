package com.skripsi.mvvm.data.api.model

import com.google.gson.annotations.SerializedName

data class SampleModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: String,
)