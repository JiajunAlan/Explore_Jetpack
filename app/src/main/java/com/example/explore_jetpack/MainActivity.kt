package com.example.explore_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.explore_jetpack.ui.theme.Explore_JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp(){
                Greeting(name = "Android")
            }
    }
}

}


@Composable
fun Myapp(content: @Composable () -> Unit){
    Explore_JetpackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //content()
            MyScreenContent()
        }
    }
}


@Composable
fun MyScreenContent(modifier:Modifier = Modifier){

    LazyColumn(modifier = modifier) {
        items(items = listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)){
            Greeting(name = "$it")
            Divider()
        }

    }
}

@Composable
fun Counter(){
    var counter by remember {
        mutableStateOf(0)
    }

    Button(onClick = { counter++ }) {
        Text(text = "clicked $counter times")
    }
}
@Composable
fun Greeting(name: String) {

        Text(text = "Hello $name!",
//            ,
            modifier = Modifier.padding(16.dp)
//                .background(color = Color.Magenta)

        )
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Myapp {
        //Greeting(name = "Android")
        MyScreenContent()
    }
}