package com.sideral.ovejas

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.startActivity
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
        return ViewHolder(layoutInflater.inflate(R.layout.activity_tarjeta_oveja, parent, false))
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
    

        fun bind(oveja:Ovejas, context: Context){
            idOveja.text = oveja.idOveja
            idOveja.setTextColor(if (oveja.sexo.equals("Hembra")) Color.parseColor("#c62828") else Color.parseColor("#1a237e"))
            itemView.setOnClickListener(View.OnClickListener {
                //Toast.makeText(context, oveja.idOveja, Toast.LENGTH_SHORT).show()
                val intent = Intent(context.applicationContext, DetalleOveja::class.java)
                intent.putExtra("IDOVEJA",oveja.idOveja)
                context.startActivity(intent)
            })

        }


    }

}



