package gt.uvg.lab05.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gt.uvg.lab05.model.Article
@Composable
fun MediumArticle(
    article: Article,
    circleColor: Color,
    squareColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(circleColor)
                )
                Text(
                    text = article.name,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif
                )
            }


            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                fontFamily = FontFamily.Serif
            )


            Text(
                text = article.resume,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Serif
            )

            Text(
                text = "${article.readTime} min de lectura · ${article.creationDate}",
                fontSize = 12.sp,
                color = Color.Gray,
                fontFamily = FontFamily.Serif
            )
        }
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(squareColor)
        )
    }
}