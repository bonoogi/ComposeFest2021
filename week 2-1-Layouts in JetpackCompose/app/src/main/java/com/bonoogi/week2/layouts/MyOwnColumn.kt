package com.bonoogi.week2.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }

        var yPosition = 0

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                it.placeRelative(x = 0, y = yPosition)
                yPosition += it.height
            }
        }
    }
}