package com.example.aacroomtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
//import com.bumptech.glide.Glide
import com.example.aacroomtutorial.databasesComponents.ArticleDB
import com.example.aacroomtutorial.databasesComponents.ArticleEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var database:ArticleDB? = null
    private var article:List<ArticleEntity> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database =  Room
            .databaseBuilder(
                applicationContext,
                ArticleDB::class.java,
                "Article")
            .allowMainThreadQueries()
            .build()

        btnCrtDb.setOnClickListener { createData() }
        btnLoadData.setOnClickListener { loadData() }
        btnPremiumChange.setOnClickListener { changePremium() }
    }

    private fun changePremium() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadData() {

        article = database!!.articleDao().getAll()

        if(article.isNullOrEmpty())
            return

        tvTitle.text = article!!.get(0).title
        tvComments.text = article!!.get(0).comment.toString()

       // Glide.with(this).load(article!!.get(0).image).into(ivImage)
    }

    private fun createData() {
        val article:ArticleEntity = ArticleEntity(
            0,"Android Architecture Components: Room" ,
            "www.myenv.net",
            "https://dev.myenv.net/wp-content/uploads/2018/06/logo_myenv_black.png",
            false,
            10
        )

        database!!.articleDao().insertAll(article)
    }


}
