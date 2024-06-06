import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quentin.newsproject.network.News

@Composable
fun NewsScreen(newsViewModel: NewsViewModel) {
    val newsResponse by newsViewModel.newsResponse

    if (newsResponse != null) {
        LazyColumn {
            items(newsResponse!!.articles) { article ->
                NewsItem(article)
            }
        }
    } else {
        CircularProgressIndicator()
    }
}

@Composable
fun NewsItem(article: News) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = article.title, style = MaterialTheme.typography.bodyLarge)
        Text(text = article.description ?: "", style = MaterialTheme.typography.bodySmall)
        // Ajoutez d'autres champs de données si nécessaire
    }
}
