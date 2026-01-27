package com.example.foxynotes.DataBase

import android.R
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "subject",
    foreignKeys = [
        ForeignKey(
            entity = Paw_print_type::class,
            parentColumns = ["paw_print_type_id"],
            childColumns = ["paw_print_type_id"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = Subject_form_type::class,
            parentColumns = ["subject_form_type_id"],
            childColumns = ["subject_form_type_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("paw_print_type_id"), Index("subject_form_type_id")]
)
data class Subject(
    @PrimaryKey(autoGenerate = true) val subject_id: Int,

    val paw_print_type_id: Int,
    val subject_form_type_id: Int,

    val subject_title: String,
    val subject_description: String,
    val subject_color: String,
    val is_active: Boolean,
    val subject_appearance_proability_multiplier: Int,

    )
