/*
 * Declaración de uso de IA:
 * Durante el desarrollo de este laboratorio, se utilizó la asistencia de Inteligencia
 * Artificial (Gemini / OpenAI) para la reestructuración de los componentes en archivos
 * separados, la sugerencia de paletas de colores y la resolución de dudas sobre la
 * aplicación de tipografías (FontFamily). Todo el código resultante fue revisado,
 * comprendido y adaptado a los requisitos del laboratorio por el autor.
 *
 * ---
 * Respuestas de la Ruta B:
 * 1.Al quitar el weight de la columna del artículo esta intenta ocupar
 *      todo el ancho necesario para que los textos se acomoden en una sola linea
 *       y eso afecta al cuadrado, porque lo saca de la visibilidad de la pantalla.
 * 2. Pasar el Modifier por parámetro nos ayuda a reutilizar componentes. Dentro solo está lo que hace
 *      y afuera se maneja el diseño, así el componente no se ata a un diseño en específico.
 */

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
        Color(0xFFFFD54F), // Amarillo estrella
        Color(0xFFF48FB1), // Rosa flor
        Color(0xFF64B5F6)  // Azul cielo
    )

    val squareColors = listOf(
        Color(0xFF81C784), // Verde árbol
        Color(0xFF3949AB), // Azul profundo espacial
        Color(0xFFAED581)  // Verde claro natural
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