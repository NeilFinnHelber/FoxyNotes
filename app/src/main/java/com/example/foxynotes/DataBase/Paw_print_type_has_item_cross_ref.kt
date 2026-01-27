package com.example.foxynotes.DataBase

import androidx.room.Entity


@Entity(
    primaryKeys = ["item_id", "paw_print_type_id"]
)
data class Paw_print_type_has_item_cross_ref(
    val item_id: Int,
    val paw_print_type_id: Int
)
