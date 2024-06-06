package com.quentin.newsproject

import NewsScreen
import NewsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.quentin.newsproject.ui.theme.NewsProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsProjectTheme {
                NewsScreen(newsViewModel = NewsViewModel())
            }
        }
    }
}