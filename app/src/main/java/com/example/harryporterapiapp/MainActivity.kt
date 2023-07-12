package com.example.harryporterapiapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.harryporterapiapp.data.api.model.Character
import com.example.harryporterapiapp.data.repository.CharacterRepo
import com.example.harryporterapiapp.ui.home.HomeViewModel
import com.example.harryporterapiapp.ui.state.CharacterState
import com.example.harryporterapiapp.ui.theme.HarryPorterApiAppTheme
import com.pluto.plugins.network.PlutoNetworkPlugin
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HarryPorterApiAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        "Android",
                        onFetchCharacterClick = {
                            homeViewModel.fetchCharacter()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onFetchCharacterClick: () -> Unit) {
    Column {
        Text(
            text = "Hello $name!",
        )
        Button(onClick = {
            onFetchCharacterClick()
        }) {
            Text(text = "View Results")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HarryPorterApiAppTheme {
        Greeting("Android",{})
    }
}