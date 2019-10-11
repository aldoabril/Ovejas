package com.sideral.ovejas.presenter

import android.view.View
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.model.ListaOvejasModelImp
import com.sideral.ovejas.view.OvejaView

class ListaOvejasPresenterImp(ovejaView: OvejaView.Lista, dbHandler: DatabaseHandler): OvejaPresenter.ListaOveja {


    private val mOvejaView = ovejaView
    private val mOvejaModel = ListaOvejasModelImp(this,dbHandler)

     override fun getOvejas(): MutableList<Oveja> {
        return mOvejaModel.getOvejas()
    }








}