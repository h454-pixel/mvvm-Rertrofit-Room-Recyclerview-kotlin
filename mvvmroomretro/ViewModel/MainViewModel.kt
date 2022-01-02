package com.example.mvvmroomretro.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.Repository.QuoteRepository
import com.example.mvvmroomretro.model.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create


class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    val quotes : LiveData<QuoteList>
        get() = repository.quotes



    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
      //

        }
    }


}