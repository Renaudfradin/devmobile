package com.quentin.newsproject.network

data class News(val title: String, val description: String, val url: String, val urlToImage: String)

data class NewsResponse(val articles: List<News>)