package com.sideral.ovejas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

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
}
