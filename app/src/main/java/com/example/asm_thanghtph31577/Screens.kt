package com.example.asm_thanghtph31577

sealed class  Screens(val screen: String){
    data object Home : Screens("home")
    data object BookMark : Screens("bookmark")
    data object Notification : Screens("notification")
    data object Profile : Screens("profile")

}