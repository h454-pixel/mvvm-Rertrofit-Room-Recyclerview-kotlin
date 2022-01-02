package com.example.mvvmroomretro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.model.Result

class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

var mList =ArrayList<Result>()

    fun setupdate(mList:ArrayList<Result>){
        this.mList =mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_ap_iscreen, parent, false)
        return ViewHolder(context ,view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Article=mList.get(position)
     //   holder.textView.text = Article.title

        holder.bindItems(Article)


    }

    override fun getItemCount(): Int {
     return mList.size
    }



    class ViewHolder(var context: Context, view: View):RecyclerView.ViewHolder(view){


        fun bindItems(Article: Result){

            val tv_userName = itemView.findViewById<TextView>(R.id.txt_view_api)
            val iv_avatar = itemView.findViewById<ImageView>(R.id.img_1)

            try {

          tv_userName.text = "Name: "+Article.title

                Glide.with(itemView).load(Article.urlToImage)
                    .apply(RequestOptions().centerCrop())
                    .into(iv_avatar)


            itemView.setOnClickListener({
                Toast.makeText(itemView.context, "Clicked Position $position", Toast.LENGTH_SHORT).show()
            })


        }catch (e:Exception){
            println(e.message)
        }
    }




    }

}