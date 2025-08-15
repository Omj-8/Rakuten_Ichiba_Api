package com.example.practice.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchScreen(onItemClick: (String) -> Unit, viewModel: MainViewModel = viewModel()) {
    var keyword by remember { mutableStateOf("") }
    val items by viewModel.items.collectAsState()

    Column {
        OutlinedTextField(
            value = keyword,
            onValueChange = { keyword = it },
            label = { Text("商品名で検索") }
        )
        Button(onClick = { viewModel.search(keyword) }) {
            Text("検索")
        }
// 商品リスト表示後、アイテムタップで遷移
        LazyColumn {
            items(items) { item ->
                ListItem(
                    headlineContent = { Text(item.itemName) },
                    supportingContent = { Text("¥${item.itemPrice}") },
                    modifier = Modifier.clickable { onItemClick(item.itemUrl) }
                )
            }
        }
    }
}