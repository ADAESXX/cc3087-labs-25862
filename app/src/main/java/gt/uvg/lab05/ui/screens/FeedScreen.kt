package gt.uvg.lab05.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gt.uvg.lab05.data.ArticleRepository
import gt.uvg.lab05.model.Article
import gt.uvg.lab05.ui.components.MediumArticle
import gt.uvg.lab05.ui.components.Tabs
import gt.uvg.lab05.ui.components.TopBar
import gt.uvg.lab05.ui.theme.SkyBlue


@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    val articles = ArticleRepository.getList()
    var selectedTab by rememberSaveable {
        mutableStateOf("Para ti")
    }
    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }
    //filtro del lecturas cortas
    var showShortReadsOnly by rememberSaveable {
        mutableStateOf(false)
    }
    //aplaudir - contador
    var applauseCount by rememberSaveable {
        mutableStateOf(0)
    }

    //Lista filtrada
    val filteredArticles = articles.filter { article ->
        val match = article.title.contains(searchQuery, ignoreCase = true) || article.author.contains(searchQuery, ignoreCase = true)

        //SWITCH
        val matchesShortReads = !showShortReadsOnly || article.readingMinutes <= 5

        //filtro de pestaña
        val matchesTab= when (selectedTab){
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }

        match && matchesShortReads && matchesTab
    }

    FeedContent(
        visibleArticles = filteredArticles,
        searchQuery = searchQuery,
        onSearchQueryChange = {searchQuery = it},
        showShortReadsOnly = showShortReadsOnly,
        onShortReadsOnlyChange = {checked ->  showShortReadsOnly = checked},
        selectedTab = selectedTab ,
        onTabSelected = {newTab -> selectedTab = newTab},
        applauseCount =  applauseCount,
        onApplaud = { applauseCount++ },
        modifier = modifier
    )

}

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp", showBackground = true)
@Composable
fun FeedContentPreviewEmpty() {
    FeedContent(
        visibleArticles = emptyList(),
        searchQuery = "",
        onSearchQueryChange = {},
        showShortReadsOnly = false,
        onShortReadsOnlyChange = {},
        selectedTab = "Para ti",
        onTabSelected = {},
        applauseCount = 0,
        onApplaud = {}
    )
}

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp", showBackground = true)
@Composable
fun FeedContentPreview(){
    FeedContent(
        visibleArticles = ArticleRepository.getList(),
        searchQuery = "Tecnologías viables en agricultura",
        onSearchQueryChange = {},
        showShortReadsOnly = false,
        onShortReadsOnlyChange = {},
        selectedTab = "Para ti",
        onTabSelected = {},
        applauseCount = 3,
        onApplaud = {}
    )
}
@Composable

fun FeedContent(
    visibleArticles: List<Article>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    showShortReadsOnly: Boolean,
    onShortReadsOnlyChange: (Boolean) -> Unit,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    applauseCount: Int,
    onApplaud: () -> Unit,
    modifier: Modifier = Modifier

){

    //Se uso IA para los colores
    val circleColors = listOf(
        Color(0xFFFFD54F),
        Color(0xFFF48FB1),
        Color(0xFF64B5F6)
    )

    val squareColors = listOf(
        Color(0xFF81C784),
        Color(0xFF3949AB),
        Color(0xFFAED581)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(24.dp))
        Tabs(
            selectedTab = selectedTab,
            onTabSelected = onTabSelected
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE0E0E0))
        )
        Spacer(modifier = Modifier.height(16.dp))
        //busqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar por título o autor") },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )
        //lecturas cortas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = onShortReadsOnlyChange,
                colors = SwitchDefaults.colors(checkedTrackColor = SkyBlue)
            )

            Text(
                text = "Solo lecturas cortas"
            )

            Spacer(
                modifier =Modifier.width(40.dp)
            )
            Text(
                text = "${visibleArticles.size} resultados",
                color = SkyBlue
            )

        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )
        //cantidad y aplausos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            TextButton(
                onClick = onApplaud,
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text(
                    text = "Aplaudir · $applauseCount",
                    color = Color.Black

                )
            }
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        //resultados
        if (visibleArticles.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "No se encontraron artículos"
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Cambia la pestaña, la búsqueda o el filtro.",
                    color = Color.Gray
                )
            }

        } else {

            // articulos filtrados
            visibleArticles.forEachIndexed { index, article ->
                MediumArticle(
                    article = article,
                    circleColor = circleColors[index % circleColors.size],
                    squareColor = squareColors[index % squareColors.size]
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE0E0E0))
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
