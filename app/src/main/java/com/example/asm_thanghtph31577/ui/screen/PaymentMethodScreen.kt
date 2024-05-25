package com.example.asm_thanghtph31577.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.R
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.ui.compose.SquareRadioButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodScreen(navControl: NavHostController) {
    var selectedOption by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xff303030),
                ),
                title = {

                    Box(modifier = Modifier.fillMaxWidth()){
                        IconButton(onClick = {
                            navControl.popBackStack()
                        },
                            modifier = Modifier.align(Alignment.TopStart)
                        ) {
                            Icon(
                                Icons.Default.ArrowBackIosNew, contentDescription ="",
                                modifier = Modifier.size(30.dp))
                        }

                        Text(text = "Payment method",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 5.dp)
                        )

                    }
                }
            )
        },
        floatingActionButton ={
            FloatingActionButton(onClick = {
                                           navControl.navigate(Screens.AddPaymentMethod.screen)
            },
                containerColor = Color.White,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "")

            }
        }
    ) {innerPadding->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Image(
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth(0.9f),
                contentScale = ContentScale.FillWidth,
                painter =
                painterResource(id = if (selectedOption==1) R.drawable.payment_card_true else R.drawable.payment_card_false),
                contentDescription =null )
            SquareRadioButton(selected = selectedOption == 1,
                onClick = { selectedOption = 1 },"Use as default payment method")
            Image(modifier = Modifier.padding(top = 50.dp)
                .fillMaxWidth(0.9f),
                contentScale = ContentScale.FillWidth,
                painter =
                painterResource(id = if (selectedOption==2) R.drawable.payment_card_true else R.drawable.payment_card_false),
                contentDescription =null )
            SquareRadioButton(selected = selectedOption == 2, onClick = { selectedOption = 2 },"Use as default payment method")




        }





    }
}
