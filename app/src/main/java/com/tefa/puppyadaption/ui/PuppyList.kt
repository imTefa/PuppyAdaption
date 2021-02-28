package com.tefa.puppyadaption.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tefa.puppyadaption.models.Animal
import com.tefa.puppyadaption.models.generateCats
import com.tefa.puppyadaption.models.generatePuppies
import dev.chrisbanes.accompanist.glide.GlideImage
import kotlinx.coroutines.launch


@Composable
fun PuppyList(isPuppies: Boolean = true, change: () -> Unit, open: (Animal) -> Unit) {
    val list = if (isPuppies) generatePuppies() else generateCats()
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()


    LazyColumn(state = scrollState) {
        items(list.size + 1) {
            if (it < list.size)
                DrawAnimal(list[it], open)
            else DrawFooter(isPuppies, change)
        }
    }

    coroutineScope.launch {
        scrollState.scrollToItem(0)
    }
}

@Composable
fun DrawAnimal(animal: Animal, open: (Animal) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { open(animal) }
    ) {
        Row(modifier = Modifier.padding(8.dp)) {

            GlideImage(
                data = animal.imgRes,
                contentDescription = "Animal logo",
                modifier = Modifier
                    .width(140.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(Modifier.align(Alignment.CenterVertically)) {
                Text(animal.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h4)
                //Spacer(modifier = Modifier.height(6.dp))
                Text(animal.age, modifier = Modifier.alpha(0.5F))
            }
        }
    }
}

@Composable
fun DrawFooter(isPuppies: Boolean, change: () -> Unit) {
    val message = "Do you love ${if (isPuppies) "Cats" else "Dogs"} more?!"
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = message, Modifier.weight(1F))
            Button(
                onClick = {
                    change()

                }
            ) {
                Text(text = "Check")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Content()
    }
}
