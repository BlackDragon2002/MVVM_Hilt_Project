package com.example.mvvm_hilt_project.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BlogNetworkEntity(
    @SerializedName("pk")
    @Expose
    var id :Int,

    @SerializedName("body")
    @Expose
    var body :String,

    @SerializedName("category")
    @Expose
    var category :String,

    @SerializedName("image")
    @Expose
    var image :String,

    @SerializedName("title")
    @Expose
    var title :String
) {
}