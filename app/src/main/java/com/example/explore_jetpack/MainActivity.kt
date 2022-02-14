package com.example.explore_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            content()
        }
    }
}

@Composable
fun MyScreenContent(){
    Column {
        Greeting(name = "Android")
        Divider()
        Greeting(name = "Here")
    }
}
@Composable
fun Greeting(name: String, ) {

        Text(text = "Hello $name!"
//            ,
//            modifier = modifier
//                .background(color = Color.Magenta)
//                .padding(16.dp)
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