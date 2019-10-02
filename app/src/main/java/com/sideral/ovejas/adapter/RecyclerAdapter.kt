package com.sideral.ovejas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.model.Item
import com.sideral.ovejas.model.Ovejas
import com.sideral.ovejas.view.ViewHolder


class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>() {
    var mItemsList: List<Item> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(items: List<Item>, context: Context){
        this.mItemsList = items
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View
        if (viewType == 0){
            view = LayoutInflater.from(parent.context).inflate(R.layout.header_type_layout,parent,false)
        }else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.grid_type_layout,parent,false)
        }
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return mItemsList.get(position).getItemType()
        //ovejas.get(position).ge
    }

    override fun getItemCount(): Int {
        return mItemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mItemsList.get(position)
        //holder.bind(item, context)
    }




}



