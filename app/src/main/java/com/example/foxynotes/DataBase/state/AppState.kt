package com.example.foxynotes.DataBase.state

data class AppState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
