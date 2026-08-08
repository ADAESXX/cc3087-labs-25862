package gt.uvg.lab05.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gt.uvg.lab05.data.ArticleRepository
import gt.uvg.lab05.ui.components.MediumArticle
import gt.uvg.lab05.ui.components.Tabs
import gt.uvg.lab05.ui.components.TopBar

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp", showBackground = true)
@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    val articles = ArticleRepository.getList()
    //Se uso IA para los colores
    val circleColors = listOf(
        Color(0xFFF0B376), // Naranja pastel
        Color(0xFF8BB1CB), // Celeste pastel
        Color(0xFFC1A4B9)  // Morado pastel
    )
    val squareColors = listOf(
        Color(0xFFE4D6C3), // Beige claro
        Color(0xFFC4D1BE), // Verde musgo pálido
        Color(0xFFD7C2A6)  // Arena oscuro
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(24.dp))
        Tabs()
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE0E0E0))
        )

        articles.forEachIndexed { index, article ->
            MediumArticle(
                article = article,
                circleColor = circleColors[index % circleColors.size],
                squareColor = squareColors[index % squareColors.size]
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFE0E0E0))
            )
        }
    }
}