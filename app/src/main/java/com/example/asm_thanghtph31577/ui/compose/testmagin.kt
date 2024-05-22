package com.example.asm_thanghtph31577.ui.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TestMargin(){
    Surface(
        modifier = Modifier.fillMaxSize(),


        content = {

            // Creating a Column Layout
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center) {

                // Creating a Text with Multiple
                // padding and borders
                Text(
                    text = "Hello Geek!",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(30.dp) // margin
                        .border(2.dp, Color.Black) // outer border
                        .padding(30.dp) // space between the borders
                        .border(2.dp, Color.Green) // inner border
                        .padding(1.dp) // padding
                )
            }
        }
    )
}