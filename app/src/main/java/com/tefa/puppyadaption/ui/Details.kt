package com.tefa.puppyadaption.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tefa.puppyadaption.R
import com.tefa.puppyadaption.models.Animal

@Composable
fun DetailsBody(animal: Animal) {

    Column(Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(animal.imgRes),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.FillBounds
        )

        Spacer(Modifier.height(16.dp))

        Text(animal.name, style = MaterialTheme.typography.h2)
        Text(animal.age, style = MaterialTheme.typography.h6 , modifier = Modifier.alpha(0.5F))
        Spacer(Modifier.height(2.dp))
        Text(animal.description, style = MaterialTheme.typography.body2)
    }
}

@Preview
@Composable
fun preview() {
    DetailsBody(animal = Animal(
        name = "Archie",
        imgRes = R.drawable.p1,
        age = "8 Months"
    ))
}