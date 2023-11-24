package com.example.material3tutorial.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.Material3TutorialTheme
import com.example.material3tutorial.ui.navigation.Screen

@Composable
fun ButtonScreen(navController: NavController) {
    Material3TutorialTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var enabled by remember {
                    mutableStateOf(true)
                }
                //Полноситью закрашенные кнопки используются для конечных действий
                Button(
                    onClick = { enabled = false },
                    enabled = enabled,
                ) {
                    Text(text = "Disable buttons")
                }

                //Используется редко, например, если кнопка находится над картинкой
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    enabled = enabled
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Add to cart",
                        //Согласно material guidelines обязательно поставить
                        // именно этот размер иконке в кнопке с текстом
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Добавить в корзину")
                }
                //Используется для множества кнопок на экране
                FilledTonalButton(
                    onClick = { /*TODO*/ },
                    enabled = enabled
                ) {
                    Text(text = "Open in browser")
                }
                //Ипользуется для менее желаемых, но нужных действий
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    enabled = enabled
                ) {
                    Text(text = "Delete account")
                }
                //Самая малозаметная кнопка
                TextButton(
                    onClick = { /*TODO*/ },
                    enabled = enabled
                ) {
                    Text(text = "Дополнительная информация")
                }
                Button(
                    onClick = { enabled = true }
                ) {
                    Text(text = "Enable buttons")
                }
                Button(
                    onClick = {
                        navController.navigate(Screen.TextFieldScreen.route)
                    },
                ) {
                    Text(text = "TextField Tutorial")
                }
            }
        }
    }
}