package net.meowcorp.android.lightmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.meowcorp.android.lightmap.ui.theme.LightColorPalette
import net.meowcorp.android.lightmap.ui.theme.LightMapTheme
import net.meowcorp.android.lightmap.util.LightMapMode
import net.meowcorp.android.lightmap.util.getCurrentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LightMapApp(getCurrentTheme())
        }
    }
}

@Composable
fun LightMapApp(theme: LightMapMode) {
    // determine the theme
    val colors: Boolean = when (theme) {
        LightMapMode.DARK -> true
        LightMapMode.LIGHT -> false
        LightMapMode.SYSTEM -> isSystemInDarkTheme()
    }

    LightMapTheme(darkTheme = colors) {
        // Compose

        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopNavbar(title = "LightMap") },
        ) { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState()),
                color = MaterialTheme.colors.background,
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    for (i in 1..1000) {
                        Text("Item $i")
                    }
                }
            }
        }
    }
}

@Composable
fun TopNavbar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = "Open Menu")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                if (MaterialTheme.colors == LightColorPalette) {
                    Icon(
                        Icons.Default.DarkMode,
                        contentDescription = "Switch to Dark Mode"
                    )
                } else {
                    Icon(
                        Icons.Default.LightMode,
                        contentDescription = "Switch to Light Mode"
                    )
                }
            }
        }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LightMapTheme {
//        Greeting("Android")
        TopNavbar(title = "boo2643634636346")
    }
}