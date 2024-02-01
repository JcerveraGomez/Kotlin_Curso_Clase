package com.coki.kurso_kotlin_clase.navegation

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coki.kurso_kotlin_clase.R
import com.coki.kurso_kotlin_clase.compontes.CustomTopBar
import com.coki.kurso_kotlin_clase.ui.theme.Purple40
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun LoginScreen(navController: NavController, activity: Activity) {
    val imagePainter = painterResource(id = R.drawable.customer_logo)
    val scope = rememberCoroutineScope()

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(topBar = {
        CustomTopBar(navController = navController)
    }, snackbarHost = { SnackbarHost(snackbarHostState) }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(horizontal = 100.dp, vertical = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = "logo",
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                OutlinedTextField(
                    label = { Text(text = "User", color = Color.Black) },
                    value = username.value,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            Log.i("LoginScreen", "onDone")
                        }
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { username.value = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Black,
                        cursorColor = Color.Black,
                        disabledPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        focusedBorderColor = if (username.value != "") Color.Black else Color.Red,
                        unfocusedBorderColor = if (username.value != "") Color.Black else Color.Red,
                        disabledBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    label = { Text(text = "Contraseña", color = Color.Black) },
                    value = password.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,

                        ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            Log.i("LoginScreen", "onDone")
                        }
                    ),
                    onValueChange = { password.value = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Black,
                        cursorColor = Color.Black,
                        disabledPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        focusedBorderColor = if (password.value.text != "") Color.Black else Color.Red,
                        unfocusedBorderColor = if (password.value.text != "") Color.Black else Color.Red,
                        disabledBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    loginCheck(username.value, password.value.text, snackbarHostState, scope)

                }, colors = ButtonDefaults.buttonColors(containerColor = Purple40)) {
                    Text(text = "Iniciar Sesión", color = Color.White)

                }

            }
        }

    }

}

fun loginCheck(
    username: String,
    password: String,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,

    ) {
    username.trim()
    Log.i("DebugLogin", "UserName:${username} ---- Password:${password}")

    if (username == "admin" && password == "admin") {
        Log.i("DebugLogin", "Login Correcto")
    } else {
        scope.launch {
            snackbarHostState.showSnackbar(
                "Usuario o contraseña incorrectos",
                duration = SnackbarDuration.Short,
                actionLabel = "cerrar",



            )

        }
    }
}