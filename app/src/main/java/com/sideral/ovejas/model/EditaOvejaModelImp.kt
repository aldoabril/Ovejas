package com.sideral.ovejas.model

import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.presenter.OvejaPresenter
import java.time.temporal.TemporalQueries.localDate
import java.util.*
import kotlin.collections.ArrayList

class EditaOvejaModelImp: OvejaModel.EditaOveja {

    val mListaOvejasPresenterImp : OvejaPresenter.EditaOveja

    constructor(ovejaModel: OvejaPresenter.EditaOveja)  {
        mListaOvejasPresenterImp = ovejaModel
    }
    override fun getOveja(idOveja: Int): Oveja {
        return Oveja("1","Aldo","M",Calendar.getInstance().time,4)
    }

    override fun borrar(idOveja: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun guardar(oveja: Oveja) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}