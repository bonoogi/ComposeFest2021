package com.bonoogi.week2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bonoogi.week2.views.ImageListItem
import kotlinx.coroutines.launch

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */

@Composable
fun LazyList(modifier: Modifier = Modifier) {
    val itemSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("맨 위로 가기")
            }
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(itemSize - 1)
                }
            }) {
                Text("맨 밑으로 가기")
            }
        }
        LazyColumn(state = scrollState, modifier = modifier) {
            items(itemSize) {
                ImageListItem(index = it)
            }
        }
    }

}

@Preview
@Composable
fun LazyListPreview() {
    Scaffold {
        LazyList(modifier =  Modifier.padding(it))
    }
}