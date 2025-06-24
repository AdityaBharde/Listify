package com.example.shoppinglistapp


import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodingApiService {
    @GET("map/api/geocode/json")
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latLng: String,
        @Query("key") key : String
    ):GeocodingResponse
}