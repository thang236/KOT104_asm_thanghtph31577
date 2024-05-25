package com.example.asm_thanghtph31577.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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

@Composable
fun Profile(navControl: NavHostController, navigationController: NavHostController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement =  Arrangement.SpaceBetween

        ) {
            Icon(
                Icons.Default.Search ,
                contentDescription = "",
                modifier = Modifier.size(30.dp),
            )
            Text(
                text = "Profile",
                color = Color(0xFF303030),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            IconButton(onClick = { navControl.navigate("login") {
                popUpTo(navControl.graph.startDestinationId){
                    inclusive = true
                }
            }
            }) {
                Icon(
                    Icons.Default.Logout,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp))
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painter = painterResource(id = R.drawable.avartar),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(60.dp)),
                contentScale = ContentScale.Crop,
            )
            Column (
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 20.dp)
            ){
                Text(text = "Thăng Hoàng",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff303030),
                    modifier = Modifier.padding(bottom = 5.dp))
                Text(text = "thanghtph31577@fpt.edu.vn",
                    color = Color(0xff808080))
            }
        }
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable { }
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .clickable { navigationController.navigate(Screens.MyOrder.screen) },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Text(text = "My orders",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff242424),
                            modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "Already have 10 orders",
                            color = Color(0xff808080)
                        )
                    }
                    Icon(imageVector = Icons.Default.NavigateNext,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),)
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable { }
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .clickable {
                        navControl.navigate(Screens.ShippingAddress.screen)
                    },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Text(text = "Shipping Addresses",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff242424),
                            modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "03 Addresses",
                            color = Color(0xff808080)
                        )
                    }
                    Icon(imageVector = Icons.Default.NavigateNext,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),)
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable { }
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .clickable { navControl.navigate(Screens.PaymentMethod.screen) },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Text(text = "Payment Method",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff242424),
                            modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "You have 2 cards",
                            color = Color(0xff808080)
                        )
                    }
                    Icon(imageVector = Icons.Default.NavigateNext,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),)
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable { }
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Text(text = "My reviews",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff242424),
                            modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "Reviews for 5 items",
                            color = Color(0xff808080)
                        )
                    }
                    Icon(imageVector = Icons.Default.NavigateNext,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),)
                }
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable { }
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Text(text = "Setting",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff242424),
                            modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "Notification, Password, FAQ, Contact",
                            color = Color(0xff808080)
                        )
                    }
                    Icon(imageVector = Icons.Default.NavigateNext,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),)
                }
            }
        }

    }
}