package com.example.rickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.apiService.ApiService
import com.example.rickandmorty.data.model.characters.BaseResponse
import com.example.rickandmorty.data.model.characters.Character
import com.geeks.rickandmorty.data.model.detailCharacter.DetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
class Repository @Inject constructor(private val api: ApiService) {

    fun getCharacter(): LiveData<List<Character>> {
        val data = MutableLiveData<List<Character>>()
        api.getCharacters().enqueue(
            object : Callback<BaseResponse> {
                override fun onResponse(p0: Call<BaseResponse>, p1: Response<BaseResponse>) {
                    data.postValue(p1.body()!!.results)
                }

                override fun onFailure(p0: Call<BaseResponse>, p1: Throwable) {
                    print(p1.localizedMessage)
                }
            }
        )
        return  data
    }
    fun getSingleCharacter(id: Int): LiveData<DetailModel> {
        val cha = MutableLiveData<DetailModel>()
        api.getSingleCharacter(id).enqueue(
            object : Callback<DetailModel>{
                override fun onResponse(p0: Call<DetailModel>, p1: Response<DetailModel>) {
                    cha.postValue(p1.body())
                }

                override fun onFailure(p0: Call<DetailModel>, p1: Throwable) {

                }

            }
        )
        return cha
    }

}