package com.example.asm_thanghtph31577.ui.compose

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.rounded.AddShoppingCart
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.asm_thanghtph31577.R
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.data.Products
import com.example.asm_thanghtph31577.data.SharedViewModel


val productLists = listOf(
    Products(1, "Black Simple Lamp", 100.0,  R.drawable.sp1, false,"Ngon lam"),
    Products(2, "Minimal Stand", 200.0,  R.drawable.sp2, false,"Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home."),
    Products(3, "Coffee Chair", 300.0,  R.drawable.sp3, false, "re"),
    Products(4, "Simple Desk", 400.0,  R.drawable.sp4, false,"deu"),

    Products(5, "Black Simple Lamp", 100.0,  R.drawable.sp1, false,"123"),
    Products(6, "Minimal Stand", 200.0,  R.drawable.sp2, false,"123"),
    Products(7, "Coffee Chair", 300.0,  R.drawable.sp3, false,"123"),
    Products(8, "Simple Desk", 400.0,  R.drawable.sp4, false,"123"),



)



@Composable
fun ProductSection(navControl: NavHostController, sharedViewModel: SharedViewModel) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(productLists.size) { index ->
            ProductItem(index, navControl, sharedViewModel)
        }
    }
}

@Composable
fun ProductItem(index: Int, navControl: NavHostController, sharedViewModel: SharedViewModel) {

    val context = LocalContext.current

    val product = productLists[index]


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                sharedViewModel.product = product

                navControl.navigate(Screens.ProductDetail.screen){

                }
            }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp) // Vertical spacing between the image and text
        ) {
            Box(modifier = Modifier.fillMaxSize()){
//                AsyncImage(
//                    model = product.image,
//                    contentDescription = "Product Image",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(150.dp) // Adjust the height as needed
//                        .clip(RoundedCornerShape(10.dp)),
//                    contentScale = ContentScale.Crop
//                )

                Image(painter = painterResource(id = product.image),
                    contentDescription ="",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                    )

                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .padding(10.dp) // margin

                        .background(
                            Color(0xFF606060).copy(alpha = 0.5f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(0.dp) // space between the borders
                        .align(Alignment.BottomEnd)

                        .padding(0.dp) // padding
                        ,




                    ) {
                    Icon(
                        imageVector = Icons.Rounded.ShoppingBag,
                        contentDescription = "",
                        Modifier
                            .size(24.dp),
                        tint = Color.White
                    )
                    
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Column (verticalArrangement = Arrangement.Center) {
                    Text(text = product.name,
                        color = Color(0xff606060),
                        fontFamily = FontFamily.Serif,
                        fontSize = 13.sp

                    )
                    Text(text = "$${product.price}",
                        color = Color(0xff303030),
                        fontFamily = FontFamily.Serif,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 5.dp))

                }

            }
        }
    }
}
