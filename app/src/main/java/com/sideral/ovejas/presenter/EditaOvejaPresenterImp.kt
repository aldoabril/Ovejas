package com.sideral.ovejas.presenter

import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.EditaOvejaModelImp
import com.sideral.ovejas.model.ListaOvejasModelImp
import com.sideral.ovejas.view.OvejaView

class EditaOvejaPresenterImp(ovejaView: OvejaView.Detalle) : OvejaPresenter.EditaOveja{

    private val mOvejaView = ovejaView
    private val mOvejaModel = EditaOvejaModelImp(this)

    override fun getOveja(idOveja: Int): Oveja {
        return mOvejaModel.getOveja(idOveja)
    }

    override fun guardar(oveja: Oveja) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun borrar(idOveja: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun actualizar(oveja: Oveja) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}