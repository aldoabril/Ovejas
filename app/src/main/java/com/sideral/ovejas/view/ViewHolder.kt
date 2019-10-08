package com.sideral.ovejas.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val view = view
   /* val idOveja = view.findViewById(R.id.idOveja) as TextView


    fun bind(item: Item, context: Context){
        idOveja.text = oveja.idOveja
        idOveja.setTextColor(if (oveja.sexo.equals("Hembra")) Color.parseColor("#c62828") else Color.parseColor("#1a237e"))
        itemView.setOnClickListener(View.OnClickListener {
            //Toast.makeText(context, oveja.idOveja, Toast.LENGTH_SHORT).show()
            val intent = Intent(context.applicationContext, DetalleOveja::class.java)
            intent.putExtra("IDOVEJA",oveja.idOveja)
            context.startActivity(intent)
        })

    }
*/

}