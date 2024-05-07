package com.example.mydots

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

/***
 * @author Daniel Garcia Portillo
 * @param dotCount cantidad de dots
 * @param currentDotPosition posicion en la que inicia y que se ira actualizando.
 * @param colorBackground color para el background de lo Dots
 * @param shape forma de los Dots
 * @param colorDotsUnselected color cuando no esta selecionado un Dot
 * @param onClickDot lambda q regresa la posiscion actual del Dot
 *
 * @sample
 * DotsIndicator(
 *                 dotCount = 3,
 *                 currentDotPosition = 1,
 *                 shape = CircleShape,
 *                 colorBackground = Color.Gray,
 *                 colorDotsUnselected = Color.White,
 *                 onClickDot = { position ->
 *                     currentDotPosition = position
 *                 }
 *             )
 *
 *
 */

@Composable
fun DotsIndicator(
    dotCount: Int = 1,
    currentDotPosition: Int = 0,
    colorBackground: Color = Color.Gray,
    shape: Shape = CircleShape,
    colorDotsUnselected: Color = Color.White,
    onClickDot: ((Int) -> Unit))
{

    LazyRow(
        modifier = Modifier.background(
            color = colorBackground,
            shape = shape
        ),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ) {
        items(dotCount) { index ->
            Dot(
                currentDot = currentDotPosition,
                isSelected = index == currentDotPosition,
                color = colorDotsUnselected,
                action = { actual ->
                    onClickDot(actual)
                }
            )
        }
    }
}

@Composable
fun Dot(isSelected: Boolean, color: Color, currentDot: Int, action:(Int) -> Unit) {
    val dotSize = if (isSelected) 12.dp else 7.dp
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(width = if (isSelected) 22.dp else dotSize, height = dotSize)
            .clip(CircleShape)
            .background(if (isSelected) Color.Black else color)
            .clickable {
                action(currentDot)
            }
    )
}

@Preview(showBackground = true)
@Composable
fun Dots(){
    var currentDotPosition by remember { mutableIntStateOf(0) }
    var dotCount by remember { mutableIntStateOf(5) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column {
            Button(
                onClick = {
                    if (currentDotPosition < dotCount - 1) {
                        currentDotPosition += 1
                    }
                }) {
                Text(text = "clickNext")
            }
            Button(
                onClick = {
                    if (currentDotPosition <= 0 ) {
                        currentDotPosition = 0
                    }else{
                        currentDotPosition -= 1
                    }
                }) {
                Text(text = "clickAtras")
            }
           DotsIndicator(
                dotCount = dotCount,
                currentDotPosition = currentDotPosition,
                shape = CircleShape,
                colorBackground = Color.Gray,
                colorDotsUnselected = Color.White,
                onClickDot = { position ->
                    currentDotPosition = position
                }
            )
        }
    }
}