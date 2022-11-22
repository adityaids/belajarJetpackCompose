package com.aditya.belajarjetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

private val nameList = listOf(
    "Mas Ibnu",
    "Adit",
    "Ferrian",
    "Iqbal",
    "Mas Ibnu",
    "Adit",
    "Ferrian",
    "Iqbal",
    "Mas Ibnu",
    "Adit",
    "Ferrian",
    "Iqbal",
    "Mas Ibnu",
    "Adit",
    "Ferrian",
    "Iqbal"
)

/*
    in this code we learn about basic jetpack compose implementation like :
    - composable anotation
    - remember delegation to keep the variable value (property delegation)
    - smallest component that we could use and combine
    - make a list view with jetpack compose
    - show default preview and custom preview
    - composable function
*/
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

// this is our main layout, surface use to modify ui,
// inside surface we use composable function to show the view
@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingList(nameList)
    }
}

/*
    this is customize preview, we can custom them (dark/light) and device to show
    our preview
*/
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HelloJetpackComposeAppPreview() {
    BelajarJetpackComposeTheme {
        HelloJetpackComposeApp()
    }
}

/*
    this is composable function, smallest part of view that we use to create the view
    we can combine some view like text, button etc here, remember don't heavy proccess
    and global variable or property here, composable function should be independent
    because composable function can be called
    several time because recomposition, it called recomposition
    you can google it for detail.
*/
// this is composable function to create the list view
@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        //this is creating the view on list position
        LazyColumn {
            items(names) { name ->
                //this is view
                Greeting(name)
            }
        }
    } else {
        Box(contentAlignment = Alignment.Center) {
            Text("No people to great :(")
        }
    }
}

//this is composable function to create a view
@Composable
fun Greeting(name: String) {
    var isExpanded by remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Card (
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.jetpack_compose),
                contentDescription = "Logo Jetpack Compose",
                modifier = Modifier.size(animatedSizeDp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hello $name!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Welcome to Dicoding!",
                    style = MaterialTheme.typography.body1.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                    contentDescription = if (isExpanded) "Show less" else "Show more"
                )
            }
        }
    }
}

// Here is default preview to show the smallest view that we included
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    BelajarJetpackComposeTheme() {
        //this is a view
        Greeting("Jetpack Compose")
    }
}