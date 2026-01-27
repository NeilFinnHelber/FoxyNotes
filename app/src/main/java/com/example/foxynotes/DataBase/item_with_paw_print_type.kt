package com.example.foxynotes.DataBase

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class item_with_paw_print_types(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "item_id",
        entityColumn = "paw_print_type_id",
        associateBy = Junction(Paw_print_type_has_item_cross_ref::class)
    )
    val paw_print_types: List<Paw_print_type>
)

data class paw_print_type_with_items(
    @Embedded val paw_print_type: Paw_print_type,
    @Relation(
        parentColumn = "paw_print_type_id",
        entityColumn = "item_id",
        associateBy = Junction(Paw_print_type_has_item_cross_ref::class)
    )
    val items: List<Item>
)
