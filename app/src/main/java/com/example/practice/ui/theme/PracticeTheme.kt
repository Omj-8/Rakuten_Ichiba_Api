package com.example.practice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PracticeTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}