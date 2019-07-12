package com.example.aacroomtutorial.databasesComponents

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
 data class ArticleEntity (

    @PrimaryKey(autoGenerate = true)
    private val uid:Int,
    private val title:String?,
    private val site:String?,
    private val image:String?,
    private val premium:Boolean?,
    private val comment:Int

)