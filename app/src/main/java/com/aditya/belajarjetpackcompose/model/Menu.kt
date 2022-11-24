package com.aditya.belajarjetpackcompose.model

import androidx.annotation.DrawableRes

data class Menu(
    @DrawableRes val image : Int,
    val title : String,
    val price : String
)