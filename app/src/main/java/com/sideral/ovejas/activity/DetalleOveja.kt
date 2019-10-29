package com.sideral.ovejas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.sideral.ovejas.R
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.helper.OvejaHelper
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.presenter.EditaOvejaPresenterImp
import com.sideral.ovejas.view.OvejaView

class DetalleOveja : AppCompatActivity(), OvejaView.Detalle {
    private val dbHandler = DatabaseHandler(this)
    val mEditaOvejaPresenterImp = EditaOvejaPresenterImp(this, dbHandler)

    override fun getOveja() {
        val intentTrigger = intent
        if (intentTrigger.hasExtra("item")) {
            mEditaOvejaPresenterImp.getDatosOveja(intentTrigger.getIntExtra("item", -1))
        }
    }

    override fun mostrarDetalleOveja(oveja: Oveja) {
       val idOveja = findViewById<TextView>(R.id.idTxtOveja)
        idOveja.setText(oveja.idOveja.toString())
        val propietario = findViewById<TextView>(R.id.idTxtPropietario)
        propietario.setText(oveja.propietario.nombre)
        val sexo = findViewById<TextView>(R.id.idTxtSexo)
        sexo.setText(oveja.sexo)
        val fecNac = findViewById<TextView>(R.id.idTxtFecNac)
        fecNac.setText(oveja.fechaNacimiento.toString())
        val edad = findViewById<TextView>(R.id.idTxtEdad)
        edad.setText(OvejaHelper().getEdad(oveja.fechaNacimiento).toString())
        val peso = findViewById<TextView>(R.id.idTxtPeso)
        peso.setText(oveja.peso.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_oveja)
        getOveja()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detalle_menu,menu)
        return true
    }

}
