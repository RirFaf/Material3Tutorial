package com.example.material3tutorial.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.Material3TutorialTheme
import com.example.material3tutorial.ui.navigation.Screen

//Согласно рекомендациям, надо слегка менять цвет топбара при прокрутке контента
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen(navController: NavController) {
    //Скрывается при пролистывании вниз и отображаетя при пролистывании вверх
    val enterAlwaysScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    //Скрывается при пролистывании вниз и отображаетя при пролистывании до самого верха
    val exitUntilCollapsedScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    //Всегда отображается, но меняет цвет при пролистывании
    val pinnedScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Material3TutorialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    //Чтобы поеведение при пролисытывании работало необходимо просписать
                    .nestedScroll(pinnedScrollBehavior.nestedScrollConnection),
                topBar = {
                    //Есть несколько видов топбаров для разных сценариев
                    //MediumTopAppBar
                    //LargeTopAppBar
                    //CenterAlignedTopAppBar
                    TopAppBar(
                        title = {
                            Text(text = "TopAppBar")
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    navController.popBackStack()
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        },
                        //Добавляем еще кнопки
                        //Согласно рекомендациям, важно добавлять не больше 3
                        //Если действий больше, то менее важные должны быть умещены в выпадающий список
                        actions = {
                            IconButton(onClick = {  }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null
                                )
                            }
                            IconButton(
                                onClick = {
                                    navController.navigate(Screen.BottomBarScreen.route)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = null
                                )
                            }
                        },
                        scrollBehavior = pinnedScrollBehavior
                    )
                }
            ) { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    content = {
                        items(100) {
                            Text(
                                text = "Item $it",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}