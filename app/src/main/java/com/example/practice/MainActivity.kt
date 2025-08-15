package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.practice.ui.MainViewModel
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.SearchScreen
import com.example.practice.ui.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                val navController = rememberNavController()
                // MainActivity.kt
                NavHost(navController, startDestination = "search") {
                    composable("search") {
                        SearchScreen(onItemClick = { url ->
                            navController.navigate("detail/$url")
                        })
                    }
                    composable("detail/{url}") { backStackEntry ->
                        val url = backStackEntry.arguments?.getString("url") ?: ""
                        DetailScreen(url)
                    }
                }
            }
        }
    }
}