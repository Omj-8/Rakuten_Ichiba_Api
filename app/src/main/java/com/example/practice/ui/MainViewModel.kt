package com.example.practice.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.api.RakutenApi
import com.example.practice.api.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    fun search(keyword: String) {
        Log.d("MainViewModel", "APIリクエスト: appId=..., keyword=$keyword")
        viewModelScope.launch {
            try {
                val response = RakutenApi.service.searchItems(
                    appId = "your_app_ID", // 楽天APIのアプリIDを入力
                    keyword = keyword
                )
                Log.d("MainViewModel", "APIレスポンス: $response")
                _items.value = response.Items.map { it.Item }
            } catch (e: Exception) {
                if (e is retrofit2.HttpException) {
                    Log.e("MainViewModel", "API error: ${e.code()} ${e.response()?.errorBody()?.string()}")
                } else {
                    Log.e("MainViewModel", "API error: ${e.message}")
                }
                _items.value = emptyList()
            }
        }
    }
}