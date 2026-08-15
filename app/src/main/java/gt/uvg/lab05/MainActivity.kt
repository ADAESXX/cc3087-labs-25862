package gt.uvg.lab05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import gt.uvg.lab05.ui.screens.FeedScreen
import gt.uvg.lab05.ui.theme.Lab05Theme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAB6_25862", "onCreate")
        enableEdgeToEdge()
        setContent {
            Lab05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FeedScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LAB6_25862", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("LAB6_25862", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LAB6_25862", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LAB6_25862", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LAB6_25862", "onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab05Theme {
        Greeting("Android")
    }
}