package com.example.aacroomtutorial.databasesComponents

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ArticleEntity::class), version = 1)
abstract class ArticleDB :RoomDatabase(){
    abstract fun articleDao():ArticleDAO
}