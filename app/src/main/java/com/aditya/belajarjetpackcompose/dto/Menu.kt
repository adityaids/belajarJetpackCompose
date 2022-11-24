package com.aditya.belajarjetpackcompose.dto

import androidx.annotation.DrawableRes

data class Menu(
    @DrawableRes val image : Int,
    val title : String,
    val price : String
)