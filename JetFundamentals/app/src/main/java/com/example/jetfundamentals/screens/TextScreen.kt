package com.example.jetfundamentals.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen


@Composable
fun TextScreen() {
  Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
    MyText()
  }

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Preview
@Composable
fun MyText() {
    //TODO write your code here
    Text(
        text = "Hello World",
        color = Color.Green,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}