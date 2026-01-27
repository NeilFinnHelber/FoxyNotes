package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_paw_print_inventory",
    primaryKeys = ["user_id", "paw_print_type_id"],
    foreignKeys = [
        ForeignKey(
            entity = User_profile::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
            ForeignKey(
                entity = Paw_print_type::class,
                parentColumns = ["paw_print_type_id"],
                childColumns = ["paw_print_type_id"],
                onDelete = ForeignKey.CASCADE
            )
    ],
    indices = [Index("user_id"), Index("paw_print_type_id")]
)
data class User_paw_print_inventory(
    val user_id: Int,
    val paw_print_type_id: Int,
    val amount: Int
)
