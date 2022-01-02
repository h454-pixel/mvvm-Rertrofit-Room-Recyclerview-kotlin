package com.example.mvvmroomretro.model


 data class QuoteList(
     var status: String,
     var totalResults: Int,
     var articles: List<Result>
 )