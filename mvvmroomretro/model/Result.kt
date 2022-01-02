package com.example.mvvmroomretro.model
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
data class Result(
   @PrimaryKey(autoGenerate = true)
     var id:Int,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)