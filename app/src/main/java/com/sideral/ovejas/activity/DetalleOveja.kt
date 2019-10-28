package com.sideral.ovejas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import com.sideral.ovejas.R
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.presenter.EditaOvejaPresenterImp
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.view.OvejaView
import java.util.*

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
            propietario.setText(oveja.propietario.nombre)
            val sexo = findViewById<EditText>(R.id.idSexo)
            sexo.setText(oveja.sexo)
            val fecha = findViewById<DatePicker>(R.id.idFechaNac)
            val calendar = Calendar.getInstance()
            calendar.time = oveja.fechaNacimiento
            val anyo = calendar.get(Calendar.YEAR)
            val mes = calendar.get(Calendar.MONTH)
            val dia = calendar.get(Calendar.DAY_OF_MONTH)
            val fechaActual = Date()
            val edadMeses = getMesesDiff(oveja.fechaNacimiento, fechaActual)
            fecha.init(anyo, mes, dia, null )
            val peso = findViewById<EditText>(R.id.idPeso)
            val edad = findViewById<EditText>(R.id.idEdad)
            edad.setText(edadMeses.toString())
            peso.setText(oveja.peso.toString())


    }

    fun getMesesDiff(fecha1: Date, fecha2: Date): Int{
        val inicio = GregorianCalendar()
        val fin = GregorianCalendar()
        inicio.time = fecha1
        fin.time = fecha2
        val difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR)
        val difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)
        return difM
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.detalle_ovejas_menu, menu)
        return true
    }
}
