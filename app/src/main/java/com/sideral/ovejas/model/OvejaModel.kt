package com.sideral.ovejas.model

import com.sideral.ovejas.entity.Oveja

interface OvejaModel {
    interface EditaOveja{
        fun guardar(oveja: Oveja)
        fun borrar(idOveja: Int)
        fun getOveja(idOveja: Int): Oveja
    }

    interface Hijo{
        fun addHijo(oveja: Oveja)
        fun getHijos():MutableList<Oveja>
    }

    interface ListaOveja{
        fun getOvejas(): MutableList<Oveja>

    }
}