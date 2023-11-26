package com.example.material3tutorial.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.Material3TutorialTheme
import com.example.material3tutorial.ui.navigation.Screen

@Composable
fun CheckScreen(navController: NavController) {
    Material3TutorialTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                var enabled by remember {
                    mutableStateOf(true)
                }
                Checkboxes(enabled)
                Spacer(modifier = Modifier.padding(32.dp))
                MySwitch(enabled)
                Spacer(modifier = Modifier.padding(32.dp))
                RadioButtons(enabled)
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { enabled = !enabled }
                    ) {
                        Text(text = if (enabled) "Disable all" else "Enable all")
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Text(text = "Prev. Tutorial")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            navController.navigate(Screen.TopBarScreen.route)
                        },
                    ) {
                        Text(text = "Next Tutorial")
                    }
                }
            }
        }
    }
}

//Создаём блок с чекбоксами
data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
private fun Checkboxes(enabled: Boolean) {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo(
                isChecked = false,
                text = "Photo"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Video"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Audio"
            ),
        )
    }
    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkboxes.indices.forEach { index ->
            checkboxes[index] = checkboxes[index].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }
    //Чекбокс с исходным промежуточным значением
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleTriState() }
    ) {
        TriStateCheckbox(
            state = triState,
            onClick = toggleTriState,
            enabled = enabled
        )
        Text(text = "Check all")
    }
    //Отображаем данные
    checkboxes.forEachIndexed { index, info ->
        Row(
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkboxes[index] = info.copy(
                        isChecked = !info.isChecked
                    )
                }
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = info.isChecked,
                onCheckedChange = { isChecked ->
                    checkboxes[index] = info.copy(
                        isChecked = isChecked
                    )
                },
                enabled = enabled
            )
            Text(text = info.text)
        }

    }
}

//Создаём переключатель
@Composable
private fun MySwitch(enabled: Boolean) {
    var switch by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = true,
                text = "Dark mode"
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = switch.text)
        //С помощью такого спейсера мы можем занять всё свободное место и поместить его между модулями
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switch.isChecked,
            onCheckedChange = { isChecked ->
                switch = switch.copy(isChecked = isChecked)

            },
            thumbContent = {
                Icon(
                    imageVector = if (switch.isChecked) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = "Switch Icon"
                )
            },
            enabled = enabled
        )
    }
}

//Создаём блок с радио кнопками
//Важное правило - один из вариантов должен быть выбран по умолчанию
@Composable
private fun RadioButtons(enabled: Boolean) {
    val radiobuttons = remember {
        mutableStateListOf(
            ToggleableInfo(
                isChecked = true,
                text = "Photo"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Video"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Audio"
            ),
        )
    }
    //Отображаем данные
    radiobuttons.forEachIndexed { index, info ->
        Row(
            modifier = Modifier
                .clickable {
                    radiobuttons.replaceAll {
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                }
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = info.isChecked,
                onClick = {
                    radiobuttons.replaceAll {
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                },
                enabled = enabled
            )
            Text(text = info.text)
        }

    }
}