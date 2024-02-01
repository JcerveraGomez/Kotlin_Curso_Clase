package com.coki.kurso_kotlin_clase.navegation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.coki.kurso_kotlin_clase.compontes.CustomTopBar
import com.coki.kurso_kotlin_clase.ui.theme.GreenLight
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.isActive
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, activity: Activity) {
    val snackbarHostState = remember { SnackbarHostState() }

    var contador by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    var jobIniciar: Job? by remember { mutableStateOf(null) }





    Scaffold(topBar = {
        CustomTopBar(navController = navController)

    },
        snackbarHost = {SnackbarHost(snackbarHostState)}

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${contador}", fontSize = 20.sp)
                    Button(onClick = {
                        if(jobIniciar?.isActive == true){
                            Log.i("HomeScreen", "Esta Activo")
                        }else{
                            Log.i("HomeScreen", "No esta Activo")
                             coroutineScope.launch {
                                 holaMundo("Hola")
                                 Log.i("HomeScreen", "Despues de ejecutar")


                             }
                        }
                    }) {
                        Text("Reanudar", color = Color.White, style =MaterialTheme.typography.bodyLarge)
                    }
                    Button(onClick = {
                        jobIniciar?.cancel()
                    }) {
                        Text("Stop", color = Color.White)
                    }
                }
            }
        }

    }
}
suspend fun holaMundo(mundo: String = "Mundo"){
    delay(3000)
    Log.i("HomeScreen", "Hola Mundo")
}

