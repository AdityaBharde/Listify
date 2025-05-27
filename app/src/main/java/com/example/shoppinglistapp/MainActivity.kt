package com.example.shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppinglistapp.ui.theme.ShoppingListAppTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListAppTheme {
                Surface(
                    modifier=Modifier.fillMaxSize().padding(WindowInsets.safeDrawing.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ){
                    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }

                    Column(
                        modifier =Modifier.fillMaxSize().padding(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick={},
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ){
                            Text("Add Item")
                        }
                        LazyColumn(
                            modifier= Modifier.fillMaxSize().padding(16.dp)
                        ) {
                            items(sItems){

                            }

                        }
                    }

                }
            }
        }
    }
}

data class ShoppingItem(val id:Int,
                        var name: String,
                        var quantity: Int,
                        var isEditing: Boolean=false
){

}

