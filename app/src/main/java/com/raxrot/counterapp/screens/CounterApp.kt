package com.raxrot.counterapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterApp(modifier: Modifier = Modifier) {

    var counter by remember { mutableStateOf(0) }

    fun IncrementCounter(){
        counter++;
    }

    fun ResetCounter(){
        counter=0
    }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have pushed the button this many times", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$counter", style = MaterialTheme.typography.headlineLarge, fontSize = 50.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {IncrementCounter()}) {
            Text(text = "Click Me", fontSize = 35.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {ResetCounter()}, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
        )) {
            Text(text = "Reset", fontSize = 25.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CounterAppPreview() {
    CounterApp()
}