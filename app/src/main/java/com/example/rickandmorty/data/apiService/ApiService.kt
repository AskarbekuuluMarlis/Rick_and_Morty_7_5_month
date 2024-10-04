package com.example.rickandmorty.data.apiService

import com.example.rickandmorty.data.model.characters.BaseResponse
import com.geeks.rickandmorty.data.model.detailCharacter.DetailModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters()
     : Call<BaseResponse>

    @GET("character/id")
    fun getSingleCharacter(id: Int
    ): Call<DetailModel>
}