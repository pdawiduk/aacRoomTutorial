package com.example.aacroomtutorial.databasesComponents

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
 data class ArticleEntity (

    @PrimaryKey(autoGenerate = true)
     val uid:Int,
     val title:String?,
     val site:String?,
     val image:String?,
     val premium:Boolean?,
     val comment:Int

)