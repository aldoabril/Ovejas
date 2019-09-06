package com.sideral.ovejas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var ovejas: MutableList<Ovejas> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(ovejas: MutableList<Ovejas>, context: Context){
        this.ovejas = ovejas
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_oveja_list, parent, false))
    }

    override fun getItemCount(): Int {
        return ovejas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = ovejas.get(position)
        holder.bind(item, context)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idOveja = view.findViewById(R.id.idOveja) as TextView
        val propietario = view.findViewById(R.id.propOveja) as TextView

        val avatar = view.findViewById(R.id.imgOveja) as ImageView

        fun bind(oveja:Ovejas, context: Context){
            idOveja.text = oveja.idOveja
            propietario.text = oveja.propietario
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, oveja.idOveja, Toast.LENGTH_SHORT).show() })

        }

    }

}



