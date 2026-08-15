package gt.uvg.lab05.ui.components

import androidx.compose.foundation.clickable
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
fun Tabs(onTabSelected: (String) -> Unit,
         selectedTab: String,
         modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Para ti",
            fontWeight = if(selectedTab == "Para ti") FontWeight.Bold else FontWeight.Normal,
            color = if(selectedTab == "Para ti") Color.Black else Color.Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable{
                onTabSelected("Para ti")
            }
        )
        Text(
            text = "Siguiendo",
            fontWeight = if(selectedTab == "Siguiendo") FontWeight.Bold else FontWeight.Normal,
            color = if(selectedTab == "Siguiendo") Color.Black else Color.Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable{
                onTabSelected("Siguiendo")
            }
        )
        Text(
            text = "Destacados",
            fontWeight = if(selectedTab == "Destacados") FontWeight.Bold else FontWeight.Normal,
            color = if(selectedTab == "Destacados") Color.Black else Color.Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable{
                onTabSelected("Destacados")
            }
        )
    }
}