package com.sideral.ovejas.entity

import java.util.*

data class Oveja(
    var idOveja: String,
    var propietario: String,
    var sexo: String,
    var fechaNacimiento: Date,
    var peso: Int
)