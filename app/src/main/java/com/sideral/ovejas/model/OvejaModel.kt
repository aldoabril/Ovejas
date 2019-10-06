package com.sideral.ovejas.model

import com.sideral.ovejas.entity.Oveja

interface OvejaModel {
    fun getOvejas(): MutableList<Oveja>;
    fun getOveja(idOveja: Int):Oveja
}