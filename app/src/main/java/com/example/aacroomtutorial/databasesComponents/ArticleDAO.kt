package com.example.aacroomtutorial.databasesComponents

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDAO {

    @Query("SELECT * FROM Article")
    fun getAll():List<ArticleEntity>

    @Query("SELECT * FROM Article WHERE uid IN(:ids)")
    fun loadByIds(ids:Array<Int>):List<ArticleEntity>

    @Insert
    fun insertAll(vararg article:ArticleEntity)

    @Query("UPDATE Article SET premium =(:premium) where uid = (:id)")
    fun changePremiumById(id:Long, premium:Boolean)

    @Delete
    fun delete(article:ArticleEntity)

    @Query("DELETE FROM Article WHERE uid = (:id)")
    fun deleteById(id:Long)
}
