package com.example.mvvmroomretro.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.db.QuoteDatabase
import com.example.mvvmroomretro.model.QuoteList
import com.example.mvvmroomretro.utilz.NetworkUtils

class QuoteRepository( /// it is viewmodel.......part of mvvm
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
)



{


    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int) {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
             val retrofitInstacc = RetrofitHelper.getApiService()

          //  val retrofitInstac =RetrofitHelper.getInstance().create(quoteService::class.java)
            val result = retrofitInstacc?.getQuotes("techcrunch","49c3c9be3cda4ebf986c1215fa83da55")
            if (result?.body() != null) {
                quoteDatabase.quoteDao().addQuotes(result.body()!!.articles)
                quotesLiveData.postValue(result.body())
            }
        } else { ////room database..
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList("first", 1, quotes)
            quotesLiveData.postValue(quoteList)
        }

    }
}
