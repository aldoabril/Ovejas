package com.sideral.ovejas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.sideral.ovejas.R
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.presenter.EditaOvejaPresenterImp
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.view.OvejaView

class DetalleOveja : AppCompatActivity(), OvejaView.Detalle {
    private val dbHandler = DatabaseHandler(this)
    val mEditaOvejaPresenterImp = EditaOvejaPresenterImp(this, dbHandler)

    override fun getOveja() {
        val intentTrigger = intent
        if (intentTrigger.hasExtra("item")) {
            mEditaOvejaPresenterImp.mostrarOveja(intentTrigger.getIntExtra("item", -1))
        }
    }


    override fun mostrarDetalleOveja(oveja: Oveja) {

            //val oveja = intentTrigger.getSerializableExtra("item") as? Oveja
            val idOvejaTextView = findViewById<EditText>(R.id.idOveja)
            idOvejaTextView.setText(oveja.idOveja.toString())
            val propietario = findViewById<EditText>(R.id.idPropietario)
            propietario.setText(oveja.propietario)
            val sexo = findViewById<EditText>(R.id.idSexo)
            sexo.setText(oveja.sexo)
            val fecha = findViewById<EditText>(R.id.idFechaNac)
            //fecha.setText(oveja.fechaNacimiento)
            val peso = findViewById<EditText>(R.id.idPeso)
            peso.setText(peso.toString())


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_oveja)
        getOveja()


    }

    fun crearParto(view: View){
        val intent = Intent(this, Partos:: class.java).apply {
            putExtra("CADENA","valor")
        }
        startActivity(intent)
    }


}
