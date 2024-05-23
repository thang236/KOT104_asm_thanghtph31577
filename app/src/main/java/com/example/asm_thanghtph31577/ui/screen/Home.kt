package com.example.asm_thanghtph31577.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.ui.compose.CategoriesSection
import com.example.asm_thanghtph31577.ui.compose.ProductSection

@Composable
fun Home(navControl: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 26.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement =  Arrangement.SpaceBetween

        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Search ,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                )

            }

            Column {
                Text(text = "Make home", color = Color(0xff909090) )
                Text(text = "BEAUTIFUL")

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp))
                
            }


        }

       CategoriesSection()
        ProductSection(navControl)

    }
}