package com.example.asm_thanghtph31577.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.ui.compose.ItemFavorite
import com.example.asm_thanghtph31577.ui.compose.SquareRadioButton
import com.example.asm_thanghtph31577.ui.compose.productList


data class Order(var id: Int,var date: String, var quantity:Int,var total:Double,var status:Int)

val listOrder = listOf(
    Order(238562312, "20/03/2024", 3,150.0,1),
    Order(238562312, "20/03/2024", 3,150.0,1),
    Order(238562312, "20/03/2024", 3,150.0,1),
    Order(238562312, "20/03/2024", 3,150.0,1),
    Order(238562312, "20/03/2024", 3,150.0,1),

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrder(navigationController: NavHostController) {
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
                        navigationController.popBackStack()
                    },
                        modifier = Modifier.align(Alignment.TopStart)
                    ) {
                        Icon(
                            Icons.Default.ArrowBackIosNew, contentDescription ="",
                            modifier = Modifier.size(30.dp))
                    }

                    Text(text = "My order",
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
    }
    ) {innerPadding->
        LazyColumn (
            modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(listOrder.size){ index ->
                ItemOrder(index = index)


            }
        }







    }
}

@Composable
fun ItemOrder( index:Int) {
    val order = listOrder[index]
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Column(
            modifier = Modifier

                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Order No${order.id}",
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = order.date,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff808080)
                )
            }


            Divider(
                color = Color(0xffF0F0F0),
                thickness = 1.7.dp,
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Text(
                        text = "Quantity: ",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff909090),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "${order.quantity}",
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Text(
                        text = "Total Amount: ",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff909090),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "$${order.total}",
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.padding( bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424)
                    )
                ) {
                    Text(text = "Detail")
                }

                Text(
                    text = "Delivered",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff27AE60),
                    fontSize = 16.sp ,
                    modifier = Modifier.padding(vertical = 10.dp)
                )


            }


        }


    }
}