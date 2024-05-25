package com.example.asm_thanghtph31577.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.ui.compose.CartSection
import com.example.asm_thanghtph31577.ui.compose.SquareRadioButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShippingAddressScreen(navControl: NavHostController){
    var selectedOption by remember { mutableIntStateOf(1  ) }

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

                        Text(text = "Shipping address",
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
            FloatingActionButton(onClick = { navControl.navigate(Screens.AddShippingAddress.screen) },
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
//            CartSection(navControl)
                SquareRadioButton(selected = selectedOption == 1,
                    onClick = { selectedOption = 1 },"Use as the shipping address")
                ShippingAddressTemp("Thăng Hoàng","Hà Đông, Hà Nội")

                SquareRadioButton(selected = selectedOption == 2, onClick = { selectedOption = 2 },"Use as the shipping address")
                ShippingAddressTemp(" Hoàng Thăng"," Hà Nội")

                SquareRadioButton(selected = selectedOption == 3, onClick = { selectedOption = 3 },"Use as the shipping address")
                ShippingAddressTemp(" Hoàng Thăng"," Hà Tây")



            }





    }
}





@Composable
fun ShippingAddressTemp(name: String, address:String) {
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 10.dp)
        .fillMaxWidth()
        .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Column(modifier = Modifier

            .fillMaxWidth()
            .background(Color.White)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = name,
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Edit, contentDescription =null)
                }
            }


            Divider(
                color = Color(0xffF0F0F0),
                thickness = 1.7.dp,
            )

            Text(text = address,
                fontFamily = FontFamily.Serif,
                color = Color(0xff909090),
                fontSize = 17.sp,
                modifier = Modifier.padding( 10.dp)
            )
        }

    }


}
