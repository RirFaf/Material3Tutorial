package com.example.material3tutorial.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.Material3TutorialTheme
import com.example.material3tutorial.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(navController: NavController) {
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
                var text by remember {
                    mutableStateOf("")
                }
                var outlinedText by remember {
                    mutableStateOf("")
                }
                var basicText by remember {
                    mutableStateOf("")
                }

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    //Чтобы изменить только один параметр текста, стоит вызвать метод .copy и прописать нужное свойство
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.Red
                    ),
                    label = {
                        Text(text = "Label")
                    },
                    placeholder = {
                        Text(text = "Placeholder")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "Leading icon")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Trailing icon"
                        )
                    },
                    prefix = {
                        Text(text = "$")
                    },
                    suffix = {
                        Text(text = ".00")
                    },
                    supportingText = {
                        Text(text = "Supporting text")
                    },
                    isError = if (!text.isNullOrBlank()) text.length > 5 else false,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                    ),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    enabled = enabled
                )
                Spacer(modifier = Modifier.padding(8.dp))
                OutlinedTextField(
                    value = outlinedText,
                    onValueChange = { outlinedText = it },
                    //Чтобы изменить только один параметр текста, стоит вызвать метод .copy и прописать нужное свойство
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.Yellow
                    ),
                    label = {
                        Text(text = "Label")
                    },
                    placeholder = {
                        Text(text = "Placeholder")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "Leading icon")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Trailing icon"
                        )
                    },
                    prefix = {
                        Text(text = "$")
                    },
                    suffix = {
                        Text(text = ".00")
                    },
                    supportingText = {
                        Text(text = "Supporting text")
                    },
                    isError = if (!outlinedText.isNullOrBlank()) outlinedText.length > 5 else false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                    ),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    enabled = enabled
                )
                Spacer(modifier = Modifier.padding(8.dp))
                //По умолчанию прозрачный, но полностью изменяемый
                BasicTextField(
                    value = basicText,
                    onValueChange = { basicText = it }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = { enabled = !enabled }
                ) {
                    Text(text = if (enabled) "Disable TextFields" else "Enable TextFields")
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.ButtonScreen.route)
                        },
                    ) {
                        Text(text = "TextField Tutorial")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
//                            navController.navigate(Screen.TextFieldScreen.route)
                        },
                    ) {
                        Text(text = "TextField Tutorial")
                    }
                }
            }
        }
    }
}