package com.aditya.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

private val nameList = listOf(
    "Mas Ibnu",
    "Adit",
    "Ferrian",
    "Iqbal"
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarJetpackComposeTheme {
                HelloJetpackComposeApp()
            }
        }
    }
}

@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingList(names = nameList)
    }
}

@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        Column() {
            for (namePerson in names) {
                Greeting(name = namePerson)
            }
        }
    } else {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "No Person To Greet :(",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded = false
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "image jetpack",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Column() {
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Hallo Dicoding"
            )
        }
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(
                imageVector = Icons.Outlined.ExpandMore,
                contentDescription = "Show more"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BelajarJetpackComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun BelajarJetpackComposePreview(){
    HelloJetpackComposeApp()
}