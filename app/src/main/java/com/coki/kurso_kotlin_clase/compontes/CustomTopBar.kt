package com.coki.kurso_kotlin_clase.compontes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CustomTopBar(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(Color.LightGray)
            .height(50.dp)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Home", color = Color.Black, fontWeight = FontWeight.Bold)
        IconButton(
            onClick = { navController.navigate("Login") },
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Black)
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Back", tint = Color.White)
        }
    }

}