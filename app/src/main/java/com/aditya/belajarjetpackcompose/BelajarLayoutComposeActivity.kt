package com.aditya.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.belajarjetpackcompose.dto.Category
import com.aditya.belajarjetpackcompose.ui.component.CategoryItem
import com.aditya.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

val dummyCategory = listOf(
    R.drawable.icon_category_all to R.string.category_all,
    R.drawable.icon_category_americano to R.string.category_americano,
    R.drawable.icon_category_cappuccino to R.string.category_cappuccino,
    R.drawable.icon_category_espresso to R.string.category_espresso,
    R.drawable.icon_category_frappe to R.string.category_frappe,
    R.drawable.icon_category_latte to R.string.category_latte,
    R.drawable.icon_category_macchiato to R.string.category_macchiato,
    R.drawable.icon_category_mocha to R.string.category_mocha,
).map { Category(it.first, it.second) }

class BelajarLayoutComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarJetpackComposeTheme {
                jetCoffeeApp()
            }
        }
    }
}

@Composable
fun jetCoffeeApp() {
    Column {
        Banner()
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
          Icon(imageVector = Icons.Default.Search,
              contentDescription = null
          )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        placeholder = {
          Text(text = stringResource(id = R.string.placeholder_search))
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    BelajarJetpackComposeTheme {
        CategoryRow()
    }
}
@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    BelajarJetpackComposeTheme {
        SearchBar()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun jetCoffeeAppPreview() {
    jetCoffeeApp()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    BelajarJetpackComposeTheme {

    }
}