package com.example.harryporterapiapp.ui.home


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.harryporterapiapp.data.api.model.Character
import com.example.harryporterapiapp.ui.state.CharacterState
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    when (state) {
        CharacterState.Empty -> {
            CharacterState.Loading
        }
        is CharacterState.Error -> {
            Text(
                text = (state as CharacterState.Error).message
            )
        }
        CharacterState.Loading -> {
            CircularProgressIndicator()
        }
        is CharacterState.Success -> {
            val res = (state as CharacterState.Success).result as List<Character>
            DataLoaded(res)
        }
    }

}

@Composable
fun DataLoaded(characters: List<Character>) {
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(characters){ character ->
            CharacterImageCard(character)
        }
    }
}

@Composable
fun CharacterImageCard(character: Character) {
//    val imageUrl =
//    CoilImage(imageRequest = { /*TODO*/ })
}
