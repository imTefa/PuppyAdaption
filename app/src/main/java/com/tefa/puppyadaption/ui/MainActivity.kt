package com.tefa.puppyadaption.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.tefa.puppyadaption.models.Animal
import com.tefa.puppyadaption.ui.theme.PuppyAdaptionTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Content()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {

    PuppyAdaptionTheme {
        Surface {
            content()
        }
    }
}

@Composable
fun Content() {
    val isPuppies = remember { mutableStateOf(true) }
    var currentScreen by rememberSaveable { mutableStateOf(Screens.ListScreen) }
    val animal: MutableState<Animal?> = remember { mutableStateOf(null) }

    Scaffold(topBar = {
        AppBar(
            currentScreen = currentScreen,
            isPuppies = isPuppies.value,
            close = { currentScreen = Screens.ListScreen })

    }
    ) { _ ->
        when (currentScreen) {
            Screens.ListScreen -> {
                PuppyList(
                    isPuppies = isPuppies.value,
                    change = { isPuppies.value = !isPuppies.value },
                    open = {
                        animal.value = it
                        currentScreen = Screens.DetailsScreen
                    }
                )
            }
            Screens.DetailsScreen -> {
                animal.value?.let {
                    DetailsBody(it)
                }
            }
        }
    }
}

@Composable
fun AppBar(currentScreen: Screens, isPuppies: Boolean, close: () -> Unit) {
    when (currentScreen) {
        Screens.ListScreen -> {
            TopAppBar(
                title = {
                    AppTitle(isPuppies = isPuppies)
                }
            )
        }
        Screens.DetailsScreen -> {
            TopAppBar(
                title = {
                    AppTitle(isPuppies = isPuppies)
                },
                actions = {
                    IconButton(onClick = { close() }) {
                        Icon(Icons.Filled.Close, contentDescription = "Close details screen")
                    }
                }
            )
        }
    }
}

@Composable
fun AppTitle(isPuppies: Boolean = true) {
    Text(text = if (isPuppies) "Puppy doopy" else "Kitty pretty")
}

enum class Screens {
    ListScreen, DetailsScreen
}