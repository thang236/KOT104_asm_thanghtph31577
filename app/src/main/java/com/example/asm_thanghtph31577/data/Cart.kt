package com.example.asm_thanghtph31577.data

import androidx.annotation.DrawableRes

data class Cart (val id: Int, val name: String, val price: Double, @DrawableRes val image: Int, var isSelected: Boolean = false, var description: String, var count: Int){
}