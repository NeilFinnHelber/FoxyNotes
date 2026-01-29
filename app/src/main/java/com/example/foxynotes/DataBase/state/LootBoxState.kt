package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box

data class LootBoxState(
    val lootBoxes: List<Loot_box> = emptyList(),
    val selectedLootBox: Loot_box? = null,

    val isOpeningLootBox: Boolean = false,
    val rewardItem: Item? = null
)

