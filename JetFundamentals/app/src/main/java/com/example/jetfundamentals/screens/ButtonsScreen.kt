package com.example.jetfundamentals.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetfundamentals.R
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun ExploreButtonsScreen() {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    MyButton()
    MyRadioGroup()
    MyFloatingActionButton()

    BackButtonHandler {
      JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
  }
}

@Composable
fun MyButton() {
  Button(
    colors = ButtonDefaults.buttonColors(
      backgroundColor = colorResource(id = R.color.colorPrimary)),
      border = BorderStroke (1.dp, color = colorResource(id = R.color.colorPrimary)),
      onClick = { /*TODO*/ }) {
        Text(
          text = "This is a button",
          color = Color.White
        )
  }
}

@Composable
fun MyRadioGroup() {
  val radioButtons = listOf(0,1,2)
  val selectedButton = remember{ mutableStateOf(radioButtons.first())}
  
  Column {
    radioButtons.forEach {index->
      val isSelected = index == selectedButton.value
      val colors = RadioButtonDefaults.colors(
        selectedColor = colorResource(id = R.color.colorPrimary),
        unselectedColor = colorResource(id = R.color.colorPrimary),
        disabledColor = Color.LightGray
      )

      RadioButton(
        selected = isSelected,
        onClick = { selectedButton.value = index},
        colors = colors
        )
    }
  }
}

@Composable
fun MyFloatingActionButton() {
  FloatingActionButton(onClick = { },
    backgroundColor = colorResource(id = R.color.colorPrimary),
    contentColor = Color.White,
    content = {
      Icon(Icons.Filled.Favorite, stringResource(id = R.string.favourite))
    }
  )
}
