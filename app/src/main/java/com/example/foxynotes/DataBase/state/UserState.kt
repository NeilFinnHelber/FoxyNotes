package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.User_profile

data class UserState(
    val user: User_profile? = null,
    val isProfileOpen: Boolean = false
)

