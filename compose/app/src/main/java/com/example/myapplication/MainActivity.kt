package com.example.myapplication

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import android.R.attr.enabled
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.BoringLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material3.Shapes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.input.pointer.pointerInput


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.trash_text),
        color = Color.Magenta,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify,
        fontFamily = FontFamily.Monospace,
        textDecoration = TextDecoration.Underline,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun HomeScreen(){
    Column (modifier = Modifier.padding(24.dp).verticalScroll(rememberScrollState())){
        Spacer(modifier = Modifier.height(30.dp))
        Btn()
        Spacer(modifier = Modifier.height(30.dp))
        clickMe()

    }
}
@Composable
fun MultipStyleText(){
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Magenta)){
                append("H")
            }
            append("ello")
            withStyle(style = SpanStyle(color = Color.Red)){
                append("F")
            }
            append("rank")
        }
    )
}

@Composable
fun ImgCompose(contentScale: ContentScale){
    Image(painterResource(id = R.drawable.school_of_fish_vortex),
        contentDescription =("swarm"),
        contentScale = contentScale,
//        modifier = Modifier.height(200.dp)
        )
}

@Composable
fun ImgURL() {
    AsyncImage(
        model = "https://static.wikia.nocookie.net/starcraft/images/e/eb/Nova_SC-GA1_Head2.jpg/revision/latest?cb=20091206141415",
        contentDescription = "Ảnh từ URL",

    )
}

@Composable
fun AvatarCricl(){
    Surface(
        modifier = Modifier.border(
            BorderStroke(2.dp, Color.Magenta),
            shape = CircleShape).clip(CircleShape)
    )
    {
        Image(painterResource(id = R.drawable.hunter_killer),
            contentDescription = null,
            contentScale = ContentScale.Crop,

        )
    }
}

@Composable
fun Btn(){
    val count = remember { mutableStateOf(0) }
    Column() {
        Text("count ${count.value}")
        Button(onClick = { count.value++},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Red,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White),
            enabled = true,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Black),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 25.dp,
                disabledElevation = 0.dp
            )
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
            Text(text = "Click me")
        }
    }
}

@Composable
fun clickMe(){
    val ContentText = remember { mutableStateOf("") }
    Column {
        Text(ContentText.value)
        Text("something", modifier = Modifier.pointerInput(Unit){
        detectTapGestures(
            onDoubleTap = {
                ContentText.value = "double tap"
            },
            onTap = {
                ContentText.value = "tap"
            },
            onLongPress = {
                ContentText.value = "long press"
            },
            onPress = {
                ContentText.value = "press"
            }
        )
    })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}