package com.example.shoppinglistapp


import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.sin

data class ShoppingItem(val id:Int,
                        var name: String,
                        var quantity: Int,
                        var isEditing: Boolean=false
)

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
                ShoppingListItem(it,{},{})
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
                        if(itemName.isNotBlank()){
                            val newitem =ShoppingItem(
                                id=sItems.size+1,
                                quantity = itemQuant.toInt(),
                                name = itemName
                            )
                            sItems=sItems+newitem
                            showDialog=false
                            itemName=""
                        }
                    }) {
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
                        onValueChange = { itemQuant=it},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    )

                }
            }
        )
    }

}

@Composable
fun ShoppingListItem(
    item:ShoppingItem,
    onEditClick :() -> Unit,
    onDeleteClick : () -> Unit
){
    Row (
        modifier = Modifier.fillMaxWidth().padding(8.dp).border(
            border = BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(20)
        )
    ){
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "Qty: ${item.quantity}", modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.padding(8.dp)
        ){
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Item")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Item")

            }
        }
    }

}
@Composable
fun ShoppingItemEditor(item : ShoppingItem, onEditComplete : (String, Int)-> Unit){
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){


    }

}

