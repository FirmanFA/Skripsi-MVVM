package com.skripsi.mvvm.data.api.model


import com.google.gson.annotations.SerializedName

data class GetNewsResponse(
    @SerializedName("status")
    val status: String = "Default",
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<Article> = listOf(Article())
) {
    data class Article(
        @SerializedName("source")
        val source: Source = Source(),
        @SerializedName("author")
        val author: String = "Default",
        @SerializedName("title")
        val title: String = "Default",
        @SerializedName("description")
        val description: String = "Default",
        @SerializedName("url")
        val url: String = "Default",
        @SerializedName("urlToImage")
        val urlToImage: String = "Default",
        @SerializedName("publishedAt")
        val publishedAt: String = "Default",
        @SerializedName("content")
        val content: String = "Default"
    ) {
        data class Source(
            @SerializedName("id")
            val id: String = "Default",
            @SerializedName("name")
            val name: String = "Default"
        )
    }
}