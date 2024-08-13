package com.example.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapp.presentation.Screen
import com.example.cryptocurrencyapp.presentation.coin_detail.components.CoinDetailScreen
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListScreen
import com.example.cryptocurrencyapp.presentation.ui.theme.CryptoCurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoCurrencyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.CoinListScreen.route
                        ) {
                            composable(route = Screen.CoinListScreen.route) {
                                CoinListScreen(navController = navController)
                            }
                            composable(route = Screen.CoinDetailScreen.route+"/{coinId}") {
                                CoinDetailScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
