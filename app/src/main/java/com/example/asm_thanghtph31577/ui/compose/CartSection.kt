package com.example.asm_thanghtph31577.ui.compose

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.R
import com.example.asm_thanghtph31577.Screens
import com.example.asm_thanghtph31577.data.Cart




val cartList = listOf(
    Cart(1, "Black Simple Lamp", 100.0,  R.drawable.sp1, false,"Ngon lam",2),
    Cart(2, "Minimal Stand", 200.0,  R.drawable.sp2, false,"Ngon vl",1),
    Cart(3, "Coffee Chair", 300.0,  R.drawable.sp3, false, "re",3),
    Cart(4, "Simple Desk", 400.0,  R.drawable.sp4, false,"deu",4),
    Cart(1, "Black Simple Lamp", 100.0,  R.drawable.sp1, false,"Ngon lam",2),
    Cart(2, "Minimal Stand", 200.0,  R.drawable.sp2, false,"Ngon vl",1),
    Cart(3, "Coffee Chair", 300.0,  R.drawable.sp3, false, "re",3),
    Cart(4, "Simple Desk", 400.0,  R.drawable.sp4, false,"deu",4),

    )
@Composable
fun CartSection(navControl: NavHostController) {
    var code by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    Box(){
        LazyColumn (
            modifier = Modifier
                .padding(bottom = 200.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(cartList.size){ index ->
                ItemCart(index = index)
                if (index < productList.size - 1) {
                    Divider(
                        color = Color(0xffF0F0F0),
                        thickness = 1.7.dp,
                        modifier = Modifier.padding( top = 10.dp)
                    )
                }

            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .align(Alignment.BottomCenter)
            .padding(bottom = 30.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = code,
                onValueChange = {code= it},
                label = { Text(text = "Enter your promo code",
                    fontSize = 13.sp ,
                    textAlign = TextAlign.Center,
                    color = Color(0xff999999),
                    ) },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(Color(0xff303030))
                            .size(54.dp)
                    ) {
                        Icon(Icons.Default.ArrowForwardIos, contentDescription = "", tint = Color.White)
                        
                    }
                }
            )
            total= calculateTotal(cartList).toString()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total:",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "$ $total",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            Button(onClick = {
                navControl.navigate("checkout/${total}")
                             },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                shape = RoundedCornerShape(13.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff303030)
                )
            ) {
                Text(text = "Check out",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(6.dp)
                    )

            }




        }
    }

}

@Composable
fun ItemCart(index: Int){
    val cart =  cartList[index]
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
        ) {
        Image(painter = painterResource(id = cart.image),
            contentDescription ="",
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Fit

        )
        Column(modifier = Modifier
            .weight(1f)
            .padding(start = 10.dp)) {
            Text(text = cart.name,
                fontSize = 17.sp,
                color = Color(0xff999999)
                )
            Text(text = "$ ${cart.price}",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 5.dp),
                fontWeight = FontWeight.SemiBold)


            SoLuong(cart.count)



        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.Cancel, contentDescription = "" )
        }

    }
}

@Composable
fun SoLuong(soLuong: Int){
    val contex = LocalContext.current
    var soLong = remember {
        mutableIntStateOf(soLuong)
    }
    Row(
        modifier = Modifier
            .padding(top = 29.dp)
            .fillMaxWidth(0.4f)
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        IconButton(onClick = { soLong.value +=1 },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp),

            ) {
            Icon(Icons.Default.Add, contentDescription = "", Modifier.size(24.dp))
        }
        Text(text = "" + soLong.value, fontSize = 15.sp, modifier = Modifier.padding(horizontal = 8.dp))
        IconButton(onClick = {
            if (soLong.value>1){
                soLong.value-=1
            }else{
                Toast.makeText(contex, "Số lượng không thể nhỏ hơn 1", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier
                .padding(0.dp)
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .padding(horizontal = 5.dp)
                .size(30.dp)
                .padding(0.dp)


            ) {
            Icon(Icons.Default.Remove, contentDescription = "",Modifier.padding().size(60.dp) )
        }
    }
}

fun calculateTotal(cartList: List<Cart>): Double {
    var total = 0.0
    for (cart in cartList) {
        total += cart.price * cart.count
    }
    return total
}