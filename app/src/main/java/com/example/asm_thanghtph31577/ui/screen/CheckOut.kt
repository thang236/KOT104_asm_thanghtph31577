package com.example.asm_thanghtph31577.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.R
import com.example.asm_thanghtph31577.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen( navControl: NavHostController , data: String?){
    val order : Double = data?.toDouble() ?: -1.0
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

                        Text(text = "Check out",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 5.dp)
                        )

                    }
                }
            )
        }
    ) {innerPadding->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(
            ) {
                ShippingAddress()
                Payment()
                DeliveryMethod()
                Total(order)


            }
            Button(onClick = {
                             navControl.navigate(Screens.Success.screen)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff242424)
                )
            ) {
                Text(text = "SUBMIT ORDER",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp),)

            }

        }



    }
}

@Composable
fun ShippingAddress() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Shipping Address",
            fontFamily = FontFamily.Serif,
            color = Color(0xff909090),
            fontSize = 17.sp,
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.Edit, contentDescription = null)

        }

    }
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 10.dp)
        .fillMaxWidth()
        .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(5.dp),

        )
        {
        Column(modifier = Modifier

            .fillMaxWidth()
            .background(Color.White)
        ) {

            Text(text = "Thăng Hoàng",
                fontFamily = FontFamily.Serif,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(10.dp)
            )
            Divider(
                color = Color(0xffF0F0F0),
                thickness = 1.7.dp,
            )

            Text(text = "Hà Đông, Hà Nội",
                fontFamily = FontFamily.Serif,
                color = Color(0xff909090),
                fontSize = 17.sp,
                modifier = Modifier.padding( 10.dp)
            )
        }

    }


}

@Composable
fun Payment() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Payment",
            fontFamily = FontFamily.Serif,
            color = Color(0xff909090),
            fontSize = 17.sp,
            )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.Edit, contentDescription = null)
            
        }

    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.card),
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(10.dp)
                , contentDescription ="" )
            Text(text = "**** **** **** 3947",Modifier.padding(start = 15.dp))


        }


    }
}

@Composable
fun DeliveryMethod() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Delivery method",
            fontFamily = FontFamily.Serif,
            color = Color(0xff909090),
            fontSize = 17.sp,
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.Edit, contentDescription = null)

        }

    }
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.delivery_method),
                modifier = Modifier.padding(15.dp)
                , contentDescription ="" )
            Text(text = "Fast (2-3days)",Modifier.padding(start = 15.dp))


        }


    }
}


@Composable
fun Total(order: Double) {
    val tong = tinhTong(order)
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 30.dp)
        .fillMaxWidth()
        .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Column(modifier = Modifier

            .fillMaxWidth()
            .background(Color.White)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Text(text = "Order:",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff909090),
                    fontSize = 17.sp,
                    modifier = Modifier.padding( 10.dp)
                )
                Text(text = "$ $order",
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Text(text = "Delivery:",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff909090),
                    fontSize = 17.sp,
                    modifier = Modifier.padding( 10.dp)
                )
                Text(text = "$ 5.0",
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

            }


            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Text(text = "Total:",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff909090),
                    fontSize = 17.sp,
                    modifier = Modifier.padding( 10.dp)
                )
                Text(text = "$ $tong",
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

            }







        }

    }


}

fun tinhTong(order : Double): Double {
    if (order == -1.0){
        return -1.0
    }else{
        val temp = order-5.0
        return temp
    }
}



