package com.bonoogi.codelab

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonoogi.codelab.ui.theme.CodelabTheme

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */

data class Message(
    val title: String,
    val body: String
)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message -> 
            MessageCard(message = message)
        }
    }
}

@Composable
fun MessageCard(message: Message) {
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

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        Column(modifier = Modifier.clickable {
            isExpanded = !isExpanded
        }) {
            Text(
                message.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 3.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    message.body,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    CodelabTheme {
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