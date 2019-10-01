package com.sideral.ovejas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.model.Ovejas
import com.sideral.ovejas.view.ViewHolder


class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>() {
    var ovejas: MutableList<Ovejas> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(ovejas: MutableList<Ovejas>, context: Context){
        this.ovejas = ovejas
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 0){

        }
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.activity_tarjeta_oveja,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return 1
        //ovejas.get(position).ge
    }

    override fun getItemCount(): Int {
        return ovejas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = ovejas.get(position)
        holder.bind(item, context)
    }




}



