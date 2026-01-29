package com.example.foxynotes.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foxynotes.DataBase.converters.AppTypeConverters
import com.example.foxynotes.DataBase.dao.DailyTaskCompletionChartDao
import com.example.foxynotes.DataBase.dao.ItemDao
import com.example.foxynotes.DataBase.dao.ItemRarityDao
import com.example.foxynotes.DataBase.dao.LootBoxDao
import com.example.foxynotes.DataBase.dao.LootBoxRarityDao
import com.example.foxynotes.DataBase.dao.NotificationDao
import com.example.foxynotes.DataBase.dao.PawPrintTypeDao
import com.example.foxynotes.DataBase.dao.PawPrintTypeItemCrossRefDao
import com.example.foxynotes.DataBase.dao.SubjectDao
import com.example.foxynotes.DataBase.dao.SubjectFormTypeDao
import com.example.foxynotes.DataBase.dao.TaskCompletedDao
import com.example.foxynotes.DataBase.dao.TaskDao
import com.example.foxynotes.DataBase.dao.TaskPrerequisiteDao
import com.example.foxynotes.DataBase.dao.TaskTypeDao
import com.example.foxynotes.DataBase.dao.ThemeDao
import com.example.foxynotes.DataBase.dao.TimerDao
import com.example.foxynotes.DataBase.dao.UnlockedItemDao
import com.example.foxynotes.DataBase.dao.UserInventoryDao
import com.example.foxynotes.DataBase.dao.UserItemInventoryDao
import com.example.foxynotes.DataBase.dao.UserProfileDao

@Database(
entities = [
    Daily_task_completion_chart::class,
    Item::class,
    Item_rarity::class,
    Loot_box::class,
    Loot_box_rarity::class,
    Notification::class,
    Paw_print_type::class,
    Paw_print_type_has_item_cross_ref::class,
    Subject::class,
    Subject_form_type::class,
    Task::class,
    Task_type::class,
    Task_completed::class,
    Task_prerequisite_for_appearance_of_task::class,
    Theme::class,
    Timer::class,
    Unlocked_item::class,
    User_item_inventory::class,
    User_lootbox_inventory::class,
    User_paw_print_inventory::class,
    User_profile::class],

    version = 1
)

@TypeConverters(AppTypeConverters::class)
abstract class FoxyNotesDatabase: RoomDatabase() {
    abstract fun daily_task_completion_chart_Dao(): DailyTaskCompletionChartDao
    abstract fun itemDao(): ItemDao
    abstract fun itemRarityDao(): ItemRarityDao
    abstract fun lootBoxDao(): LootBoxDao
    abstract fun lootBoxRarityDao(): LootBoxRarityDao
    abstract fun notificationDao(): NotificationDao
    abstract fun pawPrintTypeDao(): PawPrintTypeDao
    abstract fun pawPrintTypeItemCrossRefDao(): PawPrintTypeItemCrossRefDao
    abstract fun subjectDao(): SubjectDao
    abstract fun subjectFormTypeDao(): SubjectFormTypeDao
    abstract fun taskCompletedDao(): TaskCompletedDao
    abstract fun taskDao(): TaskDao
    abstract fun taskPrerequisiteDao(): TaskPrerequisiteDao
    abstract fun taskTypeDao(): TaskTypeDao
    abstract fun themeDao(): ThemeDao
    abstract fun timerDao(): TimerDao
    abstract fun unlockedItemDao(): UnlockedItemDao
    abstract fun userInventoryDao(): UserInventoryDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userItemInventoryDao(): UserItemInventoryDao
}