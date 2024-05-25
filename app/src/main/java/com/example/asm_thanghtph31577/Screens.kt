package com.example.asm_thanghtph31577

sealed class  Screens(val screen: String){
    data object Home : Screens("home")
    data object BookMark : Screens("bookmark")
    data object Notification : Screens("notification")
    data object Profile : Screens("profile")
    data object ProductDetail : Screens("productDetail")
    data object Cart : Screens("cart")
    data object CheckOut: Screens("checkout/{data}")
    data object MyOrder: Screens("myOrder")

    data object Success : Screens("success")
    data object ShippingAddress : Screens("shippingAddress")
    data object PaymentMethod: Screens("paymentMethod")
    data object AddShippingAddress : Screens("AddShippingAddress")
    data object AddPaymentMethod: Screens("AddPaymentMethod")





}