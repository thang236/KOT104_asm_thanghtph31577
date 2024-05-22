package com.example.asm_thanghtph31577.ui.screen


import android.app.Notification
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Profile(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Text(text = "Profile")
    }
}