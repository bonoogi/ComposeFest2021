package com.bonoogi.week2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("아이템[$it]")
        }
    }
}

@Preview
@Composable
fun SimpleListPreview() {
    SimpleList()
}