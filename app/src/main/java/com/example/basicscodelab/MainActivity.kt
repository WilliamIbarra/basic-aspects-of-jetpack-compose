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
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)){ // Able to add the button in the left of the composable element
            Column(modifier = Modifier.weight(1f)){ // The element fill all the free space
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { /*TODO: add functionality later*/ }) { // The button element
                    Text("Show more") // The text showed inside the button
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