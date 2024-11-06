package com.example.tabla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.tabla.ui.theme.TablaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TablaTheme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Barra superior",
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Barra inferior",
                    modifier = Modifier.fillMaxWidth() //El texto ba a ocupar el ancho disponible
                )
            }
        },
        modifier = Modifier.fillMaxHeight() //Solo el scaffold ba a ocupar todo el alto disponible
    ){
        innerPadding->
        Box(
            modifier = Modifier.padding(innerPadding)
        ){
            Text(
                text = "Tabla de multiplicar",
                modifier = Modifier.fillMaxWidth() //El texto ba a ocupar el ancho disponible
                .semantics { heading() },
                style = MaterialTheme.typography.headlineSmall,
            )
            //El padding establece espaciado entre los márgenes exteriores. Arrangement.spacedBy establece el espaciado entre elementos internos.
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(32.dp), // Espaciado de 32.dp entre elementos
            ){
                for (x in 1..10){
                    Row (
                        modifier = Modifier.padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(24.dp), // Espaciado de 24.dp entre elementos
                    ){
                        for(y in 1..10){
                            Text(
                                text="${x*y}",
                                modifier = Modifier.padding(vertical = 8.dp) // Espaciado vertical
                            )
                        }
                    }
                }
            }
        }
    }
}
