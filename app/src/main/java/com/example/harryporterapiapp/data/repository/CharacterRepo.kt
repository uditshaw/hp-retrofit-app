package com.example.harryporterapiapp.data.repository

import com.example.harryporterapiapp.data.api.CharacterApi
import com.example.harryporterapiapp.data.api.model.Character
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi
) {
//    Inside the constructor, we can create the dependency which needs to be passed inside the Constructor.
    suspend fun getCharacters(): List<Character>{
        return characterApi.getCharacters()
    }
}