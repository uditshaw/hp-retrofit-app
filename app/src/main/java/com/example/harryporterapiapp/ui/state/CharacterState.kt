package com.example.harryporterapiapp.ui.state

sealed class CharacterState{
    object Empty: CharacterState()
    object Loading: CharacterState()
    class Error(val message: String) : CharacterState()
    data class Success (val result: Any): CharacterState()
}
