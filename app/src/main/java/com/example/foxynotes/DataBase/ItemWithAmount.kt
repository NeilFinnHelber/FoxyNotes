package com.example.foxynotes.DataBase

import androidx.room.Embedded

data class ItemWithAmount(
    @Embedded val item: Item,
    val amount: Int
)
