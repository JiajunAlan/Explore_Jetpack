package com.example.explore_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explore_jetpack.ui.theme.Explore_JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.ic_launcher_background)
            val description = "test image"
            val title = "test image"
            ImageCard(painter = painter, contentDescription = description, title = title )
//            Myapp {
//                MyScreenContent()
//                //Counter()
//            }

    }
}

}
@Composable
fun ImageCard(
    painter:Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp

        ) {
        Box(modifier = modifier.fillMaxSize().background(
            Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black
                ),
                startY = 300f
            )
        )){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = modifier
                .fillMaxSize()
                .padding(11.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun Myapp(content: @Composable () -> Unit){
    Explore_JetpackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            //modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
            //MyScreenContent()
        }
    }
}


@Composable
fun MyScreenContent(modifier:Modifier = Modifier){

    LazyColumn(modifier = modifier) {

        items(items = listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)){
            var counter by remember {
                mutableStateOf(0)
            }
            Greeting(name = "$it")
            Button(onClick = { counter++ }) {
                Text(text = "clicked $counter times",
                    modifier = modifier
                        .padding(16.dp)
                )
            }
            Divider()

        }
    }




    //Counter()
}
//
//@Composable
//fun Counter(){
//    var counter by remember {
//        mutableStateOf(0)
//    }
//
//    Button(onClick = { counter++ }) {
//        Text(text = "clicked $counter times")
//    }
//}
@Composable
fun Greeting(name: String) {
        var isSelected by remember{
            mutableStateOf(false)
        }
    val targetColor :Color by animateColorAsState(targetValue  =if (isSelected) Color.Red else Color.Transparent)
    Surface(color = targetColor){
        Text(text = "Hello $name!",
//            ,
            modifier = Modifier
                .padding(16.dp)
                .clickable { isSelected = !isSelected }
//                .background(color = Color.Magenta)

        )
        //Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Myapp {
        //Greeting(name = "Android")
        MyScreenContent()
    }
}