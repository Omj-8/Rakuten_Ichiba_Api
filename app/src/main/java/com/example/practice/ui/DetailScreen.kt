package com.example.practice.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun DetailScreen(url: String) {
    val uriHandler = LocalUriHandler.current
    Column {
        Text("商品詳細")
        Button(onClick = { uriHandler.openUri(url) }) {
            Text("楽天市場で見る")
        }
    }
}