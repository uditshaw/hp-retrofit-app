package com.example.harryporterapiapp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harryporterapiapp.data.api.model.Character
import com.example.harryporterapiapp.data.repository.CharacterRepo
import com.example.harryporterapiapp.ui.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepo: CharacterRepo
): ViewModel(){

    private val _state = MutableStateFlow<CharacterState>(CharacterState.Empty)
    val state: StateFlow<CharacterState>
        get() = _state
//
//    init {
//        fetchCharacter()
//    }



    fun fetchCharacter() {
        try {
            viewModelScope.launch {
                val characters = characterRepo.getCharacters()
                _state.value = CharacterState.Success(characters)
            }

        } catch (e: Exception){
            onError(e.localizedMessage)
        }
    }


    private fun onError(message: String?) {
        _state.value = CharacterState.Error(message ?: "Unknown error")
    }
}