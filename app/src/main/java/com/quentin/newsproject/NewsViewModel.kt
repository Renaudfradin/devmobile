import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.quentin.newsproject.network.NewsResponse
import kotlinx.coroutines.launch


class NewsViewModel : ViewModel() {
    private val _newsResponse = mutableStateOf<NewsResponse?>(null)
    val newsResponse: State<NewsResponse?> = _newsResponse

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getTopHeadlines("us", "d0f6761ab048410d827c37fc785e3be5")
            _newsResponse.value = response
        }
    }
}
