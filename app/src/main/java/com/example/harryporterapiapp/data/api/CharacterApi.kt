package com.example.harryporterapiapp.data.api

import com.example.harryporterapiapp.data.api.model.Character
import retrofit2.http.GET

interface CharacterApi {
    @GET(ApiConstants.END_POINT)
    suspend fun getCharacters(): List<Character>
}