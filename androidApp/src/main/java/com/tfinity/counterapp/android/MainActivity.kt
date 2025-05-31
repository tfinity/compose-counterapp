package com.tfinity.counterapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.tfinity.counterapp.Greeting

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val counter= remember {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("Compose Counter App", color = Color.White)
                                },
                                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue)
                            )
                        },
                        floatingActionButton = { FloatingActionButton(
                            onClick = {
                                counter.value++
                            },
                            shape = FloatingActionButtonDefaults.largeShape
                        ) {
                            Icon(Icons.Default.Add,"Add")
                        } }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("You have clicked the button this many times:")
                            Text(
                                "${counter.value}", style = MaterialTheme.typography.headlineMedium
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String, modifier: Modifier) {
    Text(text = text, modifier = modifier)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!", Modifier)
    }
}
