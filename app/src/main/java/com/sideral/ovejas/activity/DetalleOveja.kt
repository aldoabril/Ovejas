package com.sideral.ovejas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.sideral.ovejas.R
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.view.OvejaView

class DetalleOveja : AppCompatActivity(), OvejaView.Detalle {
    override fun mostrarDetalleOveja() {
        val intentTrigger = intent
        if (intentTrigger.hasExtra("item")){
            val oveja = intentTrigger.getSerializableExtra("item") as? Oveja
            val idOvejaTextView = findViewById<EditText>(R.id.idOveja)
            idOvejaTextView.setText(oveja?.idOveja)
            val propietario = findViewById<EditText>(R.id.idPropietario)
            propietario.setText(oveja?.propietario)
            val sexo = findViewById<EditText>(R.id.idSexo)
            sexo.setText(oveja?.sexo)
            val peso = findViewById<EditText>(R.id.idPeso)
            peso.setText(40.toString())

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_oveja)
        mostrarDetalleOveja()


    }

    fun crearParto(view: View){
        val intent = Intent(this, Partos:: class.java).apply {
            putExtra("CADENA","valor")
        }
        startActivity(intent)
    }


}
