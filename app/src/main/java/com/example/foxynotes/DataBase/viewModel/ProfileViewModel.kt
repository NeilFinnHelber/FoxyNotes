package com.example.foxynotes.DataBase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxynotes.DataBase.dao.UserProfileDao
import com.example.foxynotes.DataBase.event.UserEvent
import com.example.foxynotes.DataBase.state.UserState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModel(private val dao: UserProfileDao) : ViewModel() {

    private val _state = MutableStateFlow(UserState())

    private val _user = dao.getUser()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    val state = combine(_state, _user) { state, user ->
        state.copy(user = user)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        UserState()
    )

    fun onEvent(event: UserEvent) {
        when (event) {

            is UserEvent.ChangeTheme -> {
                state.value.user?.let { user ->
                    viewModelScope.launch {
                        dao.updateUser(user.copy(theme_id = event.themeId))
                    }
                }
            }

            is UserEvent.ChangeTimer -> {
                state.value.user?.let { user ->
                    viewModelScope.launch {
                        dao.updateUser(user.copy(timer_id = event.timerId))
                    }
                }
            }

            UserEvent.ShowProfile -> {
                _state.update { it.copy(isProfileOpen = true) }
            }

            UserEvent.HideProfile -> {
                _state.update { it.copy(isProfileOpen = false) }
            }
        }
    }
}
