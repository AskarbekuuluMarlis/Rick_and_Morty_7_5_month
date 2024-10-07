package com.example.rickandmorty.data.model.characters

import com.geeks.rickandmorty.data.model.characters.Info
import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)