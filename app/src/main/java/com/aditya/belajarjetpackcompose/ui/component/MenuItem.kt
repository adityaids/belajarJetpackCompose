package com.aditya.belajarjetpackcompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.belajarjetpackcompose.R
import com.aditya.belajarjetpackcompose.model.Menu

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = modifier.padding(8.dp)){
                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

val dummyMenu = listOf(
    Menu(
        R.drawable.menu1,
        "Tiramisu Ice Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu2,
        "Americano Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu3,
        "Cappucino Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu4,
        "Ekspresso Coffee",
        "Rp18.000"
    )
)

val dummyBestSellerMenu = listOf(
    Menu(
        R.drawable.menu4,
        "Ekspresso Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu2,
        "Americano Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu1,
        "Tiramisu Ice Coffee",
        "Rp18.000"
    ),
    Menu(
        R.drawable.menu3,
        "Cappucino Coffee",
        "Rp18.000"
    )
)


@Preview(showBackground = true)
@Composable
fun MenuItemPreview(){
    MaterialTheme {
        MenuItem(
            menu = Menu(R.drawable.menu2, "Hot Pumpkin Spice Latte Premium", "Rp 18.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}