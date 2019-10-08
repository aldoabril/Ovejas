package com.sideral.ovejas.presenter

import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.ListaOvejasModelImp
import com.sideral.ovejas.view.OvejaView

class ListaOvejasPresenterImp(ovejaView: OvejaView.Lista): OvejaPresenter.ListaOveja {


    private val mOvejaView = ovejaView
    private val mOvejaModel = ListaOvejasModelImp(this)

     override fun getOvejas(): MutableList<Oveja> {
        return mOvejaModel.getOvejas()
    }








}