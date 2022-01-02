package com.example.mvvmroomretro.Api
import com.example.mvvmroomretro.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface QuoteService {

    @GET("top-headlines")
    suspend fun getQuotes(@Query("sources") limit: String, @Query("apiKey") limit2: String?) : Response<QuoteList>
}