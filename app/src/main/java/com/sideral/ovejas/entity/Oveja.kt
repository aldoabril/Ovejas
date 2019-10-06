package com.sideral.ovejas.entity

import java.io.Serializable
import java.time.LocalDate
import java.util.*

 class Oveja(idOveja: String, propietario:String,sexo: String, fechaNacimiento: Date, peso: Int): Serializable{
   val idOveja = idOveja
   val propietario = propietario
   val sexo = sexo
   val fechaNacimiento = fechaNacimiento
   val peso = peso

 }