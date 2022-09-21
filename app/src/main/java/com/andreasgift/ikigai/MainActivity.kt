package com.andreasgift.ikigai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            val result = PokeApi.create().fetchPokemonName()
            if (result.isSuccessful) {
                setContentView(ComposeView(this@MainActivity).apply {
                    setContent {
                        MaterialTheme {
                            PokemonView(result.body()!!.results)
                        }
                    }
                })
            }
        }
    }
}

@Composable
fun PokemonView(data: List<Pokemon>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(data) { index, pokemon ->
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(android.R.drawable.star_big_off),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Yellow, CircleShape)   // add a border (optional)
                )
                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Text(
                        text = String.format("#%03d", index + 1),
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(text = pokemon.name ?: "", fontSize = 16.sp, color = Color.LightGray)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    MaterialTheme {
        PokemonView(
            arrayListOf(
                Pokemon("Bulbasaur", ""),
                Pokemon("Pikachu", "")
            )
        )
    }
}