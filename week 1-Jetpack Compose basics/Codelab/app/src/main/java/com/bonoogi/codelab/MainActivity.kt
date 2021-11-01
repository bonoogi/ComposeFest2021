package com.bonoogi.codelab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bonoogi.codelab.ui.theme.CodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    Conversation(
                        messages = listOf(
                            Message("안녕하세요", "제 이름은 첫식이입니다."),
                            Message("안넝하세요", "제 이름은 둘식이입니다."),
                            Message("안넝허세요", "제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다. 제 이름은 삼식이입니다."),
                            Message("안넝허네요", "제 이름은 사식이입니다."),
                            Message("안넝허네여", "제 이름은 오식이입니다."),
                            Message("악넝허네여", "제 이름은 엿식이입니다."),
                            Message("악넘허네여", "제 이름은 칠식이입니다."),
                            Message("악넘어네여", "제 이름은 팔식이입니다."),
                            Message("악넘어게여", "제 이름은 홉식이입니다."),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "Profile",
            Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(
                "Hell, yeah",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 8.dp,
            ) {
                Text(
                    "$name!",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    CodelabTheme {
        Greeting("Android")
    }
}