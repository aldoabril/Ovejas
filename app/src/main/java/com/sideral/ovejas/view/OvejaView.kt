package com.sideral.ovejas.view

import com.sideral.ovejas.entity.Oveja

interface OvejaView {

    interface Lista{
        fun mostrarOvejas()
    }
    interface Detalle{
        fun mostrarDetalleOveja()
    }


}