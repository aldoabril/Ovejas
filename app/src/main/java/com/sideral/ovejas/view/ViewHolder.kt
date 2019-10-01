package com.sideral.ovejas.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.activity.DetalleOveja
import com.sideral.ovejas.model.Ovejas

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val idOveja = view.findViewById(R.id.idOveja) as TextView


    fun bind(oveja: Ovejas, context: Context){
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