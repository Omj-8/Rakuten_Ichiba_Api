package com.example.practice.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class Item(
    val itemName: String,
    val itemPrice: Int,
    val itemUrl: String,
    val mediumImageUrls: List<ImageUrl>
)

data class ImageUrl(val imageUrl: String)

data class RakutenResponse(val Items: List<ItemWrapper>)
data class ItemWrapper(val Item: Item)

interface RakutenService {
    @GET("Search/20170706")
    suspend fun searchItems(
        @Query("applicationId") appId: String,
        @Query("keyword") keyword: String
    ): RakutenResponse
}

object RakutenApi {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://app.rakuten.co.jp/services/api/IchibaItem/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RakutenService = retrofit.create(RakutenService::class.java)
}