package com.example.mvvmroomretro
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.Repository.QuoteRepository
import com.example.mvvmroomretro.ViewModel.MainViewModel
import com.example.mvvmroomretro.ViewModel.MainViewModelFactory
import com.example.mvvmroomretro.adapter.RecyclerAdapter
import com.example.mvvmroomretro.model.QuoteList
import com.example.mvvmroomretro.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    var api:QuoteService? = null
    var newsList = ArrayList<Result>()
    var recyclerView: RecyclerView? = null
    var recyclerAdapter: RecyclerAdapter? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.rcy_1)
      progressBar = findViewById<View>(R.id.progress_circular_1) as ProgressBar
        progressBar!!.visibility = View.VISIBLE
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setAdapter(recyclerAdapter)




        val repository = (application as QuoteApplication).quoteRepository


        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer{
        if(it !=null){
           //newsList= it.articles as ArrayList<Result>
            recyclerAdapter!!.setupdate(it.articles as ArrayList<Result>)

               Toast.makeText(this@MainActivity, " no facthing problum", Toast.LENGTH_SHORT).show()
            progressBar!!.visibility = View.INVISIBLE
        }
        else{

            Toast.makeText(this@MainActivity, "facthing problum", Toast.LENGTH_SHORT).show()
        }

        })
    }
}