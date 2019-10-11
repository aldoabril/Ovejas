package com.sideral.ovejas.entity

import java.io.Serializable
import java.time.LocalDate
import java.util.*

 class Oveja: Serializable{

     var idOveja : Int = 0
     var propietario : String = ""
     var sexo : String = ""
     var fechaNacimiento: Date = Calendar.getInstance().time
     var peso : Double = 0.0


 }