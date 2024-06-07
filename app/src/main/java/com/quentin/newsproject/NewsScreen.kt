import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
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
        article.description?.let {
            Text(text = it, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(8.dp))
        article.urlToImage?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.publishedAt, style = MaterialTheme.typography.bodySmall)
        // Ajoutez d'autres champs de données si nécessaire
    }
}
