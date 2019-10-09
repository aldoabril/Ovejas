package com.sideral.ovejas.presenter

import com.sideral.ovejas.entity.Oveja

interface OvejaPresenter {

    interface EditaOveja{
        fun guardar(oveja: Oveja)
        fun borrar(idOveja: Int)
        fun actualizar(oveja: Oveja)
        fun mostrarOveja(idOveja: Int)

    }

    interface Hijo{
        fun addHijo(oveja: Oveja)
        fun getHijos():MutableList<Oveja>
    }

    interface ListaOveja{
        fun getOvejas(): MutableList<Oveja>

    }
}