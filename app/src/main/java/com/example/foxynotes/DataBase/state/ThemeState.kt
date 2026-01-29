package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Theme

data class ThemeState(
    val themes: List<Theme> = emptyList(),
    val activeTheme: Theme? = null,

    val isDarkMode: Boolean = false
)

