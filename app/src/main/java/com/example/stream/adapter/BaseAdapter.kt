package com.example.stream.adapter

import Items
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stream.R
import com.example.stream.ui.ViewerActivity


class BaseAdapter(context:Context,videoslist:ArrayList<Items>) : RecyclerView.Adapter<BaseAdapter.viewholder>() {
    var context:Context
    var videoslist:MutableList<Items>
    init {
        this.context=context
        this.videoslist=videoslist
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

       var view:View= LayoutInflater.from(context).inflate(R.layout.contentlayout,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int =videoslist?.size!!

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var currentposition=position+1
        holder.trendnumber.setText("Trend Number $currentposition ")
    }

    inner class viewholder (itemView: View) : RecyclerView.ViewHolder(itemView)  {

        var trendnumber: TextView
        init {
            trendnumber=itemView.findViewById(R.id.trend_number)
            itemView.setOnClickListener(View.OnClickListener {

                var intent: Intent = Intent(context, ViewerActivity::class.java)
                intent.putExtra("tag",videoslist.get(adapterPosition).id)
                context.startActivity(intent)

            })
        }

   }
}