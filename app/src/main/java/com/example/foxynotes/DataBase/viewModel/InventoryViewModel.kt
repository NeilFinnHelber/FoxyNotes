package com.example.foxynotes.DataBase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxynotes.DataBase.dao.ItemDao
import com.example.foxynotes.DataBase.dao.LootBoxDao
import com.example.foxynotes.DataBase.event.InventoryEvent
import com.example.foxynotes.DataBase.repository.InventoryRepository
import com.example.foxynotes.DataBase.state.InventoryState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class InventoryViewModel(private val repository: InventoryRepository) : ViewModel() {

    private val currentUserId = 1

    private val _state = MutableStateFlow(InventoryState())

    val items = repository.getItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val lootBoxes = repository.getLootBoxes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state, items, lootBoxes) { state, items, boxes ->
        state.copy(
            items = items,
            lootBoxes = boxes
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), InventoryState())


    fun onEvent(event: InventoryEvent) {
        when (event) {

            is InventoryEvent.PurchaseItem -> {
                viewModelScope.launch {
                    repository.purchaseItem(
                        userId = currentUserId,
                        itemId = event.itemId,
                        amount = event.amount
                    )
                }
            }

            is InventoryEvent.OpenLootBox -> {
                viewModelScope.launch {
                    repository.openLootBox(
                        userId = currentUserId,
                        lootBoxId = event.lootBoxId
                    )
                }
            }

            InventoryEvent.HideDialog -> {
                _state.update { it.copy(isDialogOpen = false) }
            }
        }
    }
}
