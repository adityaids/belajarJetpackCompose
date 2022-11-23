package com.aditya.belajarjetpackcompose.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @DrawableRes val imageCategory : Int,
    @StringRes val textCategory : Int
)