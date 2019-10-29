package com.sideral.ovejas.helper

import java.util.*

class OvejaHelper {
    fun getEdad(fechaNacimiento: Date): Int{
        val fechaActual = Date()
        val edadMeses = getMesesDiff(fechaNacimiento, fechaActual)
        return edadMeses
    }

    private fun getMesesDiff(fecha1: Date, fecha2: Date): Int{
        val inicio = GregorianCalendar()
        val fin = GregorianCalendar()
        inicio.time = fecha1
        fin.time = fecha2
        val difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR)
        val difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)
        return difM
    }

}