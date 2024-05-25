package com.example.asm_thanghtph31577.ui.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SquareRadioButton(selected: Boolean, onClick: () -> Unit, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .padding(top = 30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .padding(4.dp)
                .border(1.dp , Color.Black)
                .clickable { onClick() }
                .background(if (selected) Color.Black else Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Canvas(modifier = Modifier.size(24.dp)) {
                    scale(0.8f) {
                        drawLine(
                            color = Color.White,
                            start = Offset(size.width * 0.2f, size.height * 0.5f),
                            end = Offset(size.width * 0.4f, size.height * 0.7f),
                            strokeWidth = 3f
                        )
                        drawLine(
                            color = Color.White,
                            start = Offset(size.width * 0.4f, size.height * 0.7f),
                            end = Offset(size.width * 0.8f, size.height * 0.3f),
                            strokeWidth = 3f
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 16.sp, color = if (selected) Color.Black else Color(0xff999999))
    }
}