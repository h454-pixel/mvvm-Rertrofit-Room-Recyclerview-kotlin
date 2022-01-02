package com.example.mvvmroomretro

import android.app.Application
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.Repository.QuoteRepository
import com.example.mvvmroomretro.db.QuoteDatabase

class QuoteApplication :Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}