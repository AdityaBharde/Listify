package com.example.shoppinglistapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng

@Composable
fun LocationSelectionScreen(
    location: LocationData,
    onLocationSelected :(LocationData)->Unit) {

    val userLocation = remember {
        mutableStateOf(LatLng(location.latitude,location.longitude))
    }

    var cameraPositionState =
}