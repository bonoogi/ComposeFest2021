package com.bonoogi.week2

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */

@Composable
fun LazyList(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState, modifier = modifier) {
        items(100) {
            Text("아이템 $it")
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