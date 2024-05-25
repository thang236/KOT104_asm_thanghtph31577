package com.example.asm_thanghtph31577

import CartScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm_thanghtph31577.data.SharedViewModel
import com.example.asm_thanghtph31577.ui.screen.AddPaymentMethod
import com.example.asm_thanghtph31577.ui.screen.AddShippingAddress
import com.example.asm_thanghtph31577.ui.screen.BottomNavigation
import com.example.asm_thanghtph31577.ui.screen.CheckOutScreen
import com.example.asm_thanghtph31577.ui.screen.LoginScreen
import com.example.asm_thanghtph31577.ui.screen.PaymentMethodScreen
import com.example.asm_thanghtph31577.ui.screen.ProductDetail
import com.example.asm_thanghtph31577.ui.screen.ShippingAddressScreen
import com.example.asm_thanghtph31577.ui.screen.SignUp
import com.example.asm_thanghtph31577.ui.theme.Asm_thanghtph31577Theme
import com.example.asm_thanghtph31577.ui.screen.SplashScreen
import com.example.asm_thanghtph31577.ui.screen.SuccessScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Asm_thanghtph31577Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navControl = rememberNavController()
                    val sharedViewModel: SharedViewModel = viewModel()


                    NavHost(
                        navController = navControl,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            SplashScreen(navControl)
                        }
                        composable("login") {
                            LoginScreen(navControl)
                        }
                        composable("sign") {
                            SignUp(navControl)
                        }

                        composable("bottom") {
                            BottomNavigation(navControl,sharedViewModel )
                        }
                        composable(Screens.ProductDetail.screen) {
                            ProductDetail(navControl, sharedViewModel)
                        }
                        composable(Screens.Cart.screen) {
                            CartScreen(navControl)
                        }
                        composable(Screens.CheckOut.screen) { backStackEntry ->
                            CheckOutScreen(navControl,data = backStackEntry.arguments?.getString("data"))
                        }
                        composable(Screens.Success.screen) {
                            SuccessScreen(navControl)
                        }
                        composable(Screens.ShippingAddress.screen) {
                            ShippingAddressScreen(navControl)
                        }
                        composable(Screens.AddShippingAddress.screen) {
                            AddShippingAddress()
                        }

                        composable(Screens.PaymentMethod.screen) {
                            PaymentMethodScreen(navControl)
                        }
                        composable(Screens.AddPaymentMethod.screen) {
                            AddPaymentMethod()
                        }




                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Asm_thanghtph31577Theme {
            Greeting("Android")
        }
    }
}