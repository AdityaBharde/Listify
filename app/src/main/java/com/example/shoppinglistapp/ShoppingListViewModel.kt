package com.example.shoppinglistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    var sItems by mutableStateOf(listOf<ShoppingItem>())
        private set

    fun addShoppingItem(item: ShoppingItem) {
        sItems = sItems + item
    }

    fun removeShoppingItem(item: ShoppingItem) {
        sItems = sItems - item
    }

    fun updateShoppingItem(item: ShoppingItem, newName: String, newQuantity: Int) {
        val updatedList = sItems.map {
            if (it.id == item.id) {
                it.copy(name = newName, quantity = newQuantity, isEditing = false)
            } else {
                it
            }
        }
        sItems = updatedList
    }

    fun toggleEditMode(item: ShoppingItem) {
        val updatedList = sItems.map {
            if (it.id == item.id) {
                it.copy(isEditing = !it.isEditing)
            } else {
                it.copy(isEditing = false)
            }
        }
        sItems = updatedList
    }
}