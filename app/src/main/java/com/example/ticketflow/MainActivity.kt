package com.example.ticketflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ticketflow.ui.enter_screen.EnterScreen
import com.example.ticketflow.ui.theme.TicketFlowTheme
import com.example.ticketflow.ui.title.TitleSplashScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val isLoggedIn = remember { mutableStateOf(false) }

    // Splash screen
    LaunchedEffect(Unit) {
        delay(2000) // Simulating a delay for demonstration
        isLoggedIn.value = true
    }

    if (isLoggedIn.value) {
        // User is logged in, show the home screen
        EnterScreen()
    } else {
        // User is not logged in, show the login screen
        TitleSplashScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TicketFlowTheme {

    }
}