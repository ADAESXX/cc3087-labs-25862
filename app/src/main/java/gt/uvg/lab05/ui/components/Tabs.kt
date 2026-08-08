package gt.uvg.lab05.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily

@Composable
fun Tabs(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Para ti", fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = FontFamily.Serif)
        Text(text = "Siguiendo", color = Color.Gray, fontSize = 14.sp, fontFamily = FontFamily.Serif)
        Text(text = "Destacados", color = Color.Gray, fontSize = 14.sp, fontFamily = FontFamily.Serif)
    }
}