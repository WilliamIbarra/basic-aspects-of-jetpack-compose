package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodeLabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose")) {

        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) { // add all the text views for each text in the list
                Greeting(name = name)
            }
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) } // This variable uses remember to save the previous status
    val extraPadding = if (expanded.value) 48.dp else 0.dp //  This variable saves the expanded mode isn't remembered is calculated

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)){ // Able to add the button in the left of the composable element
            Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)){ // The element fill all the free space
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value  }) { // The button element, Change the value of the variable
                    Text(if (expanded.value) "Show less" else "Show more") // The text showed inside the button
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320) //Emulate a common width for a small phone like a 320dp screen
@Composable
fun GreetingPreview() {
    BasicsCodeLabTheme {
        Greeting("Android")
    }
}