package com.example.shoppinglistapp

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.sin

data class ShoppingItem(val id:Int,
                        var name: String,
                        var quantity: Int,
                        var isEditing: Boolean=false
){

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListapp(){
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuant by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize().padding(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick={showDialog=true},
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

    if(showDialog){
        AlertDialog(
            onDismissRequest = {
                showDialog=false
            },
            confirmButton = {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ){
                Button(
                    onClick = {

                    },
                    ) {
                    Text("Add")

                }
                Button(
                    onClick = {showDialog=false},
                    ) {

                    Text("Cancel")

                }
            }},
            title = {
                Text("Add Shopping item")
            },
            text={
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName=it },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    )
                    OutlinedTextField(
                        value = itemQuant,
                        onValueChange = { itemName=it},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    )

                }
            }
        )
    }

}
