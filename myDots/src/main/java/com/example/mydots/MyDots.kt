package com.example.mydots

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip


@Composable
fun DotsIndicator(dotCount: Int, currentDotPosition: Int) {
    LazyRow(
        modifier = Modifier.background(
            color = Color.Gray,
            shape = CircleShape
        ),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp)
    ) {
        items(dotCount) { index ->
            Dot(index == currentDotPosition, color = Color.White)
        }
    }
}

@Composable
fun Dot(isSelected: Boolean, color: Color) {
    val dotSize = if (isSelected) 12.dp else 7.dp
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(width = if (isSelected) 22.dp else dotSize, height = dotSize)
            .clip(CircleShape)
            .background(if (isSelected) Color.Black else color)
    )
}