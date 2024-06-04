import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Card {
    @Composable
    fun CardMinimalExample() {
        Card() {
            Text(text = "Hello, world!")
        }
    }
}