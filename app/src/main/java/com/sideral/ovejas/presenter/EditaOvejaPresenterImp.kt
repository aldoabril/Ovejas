package com.sideral.ovejas.presenter

import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.model.EditaOvejaModelImp
import com.sideral.ovejas.view.OvejaView

class EditaOvejaPresenterImp(ovejaView: OvejaView.Detalle, dbHandler: DatabaseHandler) : OvejaPresenter.EditaOveja{

    private val mOvejaView = ovejaView
    private val mOvejaModel = EditaOvejaModelImp(this,dbHandler)


    override fun getDatosOveja(idOveja: Int) {
          val oveja = mOvejaModel.getOveja(idOveja)
          mOvejaView.mostrarDetalleOveja(oveja)
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