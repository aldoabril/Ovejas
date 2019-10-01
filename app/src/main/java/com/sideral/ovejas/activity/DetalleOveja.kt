package com.sideral.ovejas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.sideral.ovejas.R

class DetalleOveja : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_oveja)

        val intentTrigger = intent
        if (intentTrigger.hasExtra("IDOVEJA")){
            val idOveja = intentTrigger.getStringExtra("IDOVEJA")
            val idOvejaTextView = findViewById<EditText>(R.id.idOveja)
            idOvejaTextView.setText(idOveja)
        }

    }

    fun crearParto(view: View){
        val intent = Intent(this, Partos:: class.java).apply {
            putExtra("CADENA","valor")
        }
        startActivity(intent)
    }


}
