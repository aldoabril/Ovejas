package com.sideral.ovejas.model

import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.presenter.OvejaPresenter
import java.util.*
import kotlin.collections.ArrayList

class ListaOvejasModelImp: OvejaModel.ListaOveja {
    val mListaOvejasPresenterImp : OvejaPresenter.ListaOveja

    constructor(ovejaModel: OvejaPresenter.ListaOveja)  {
        mListaOvejasPresenterImp = ovejaModel
    }

    override fun getOvejas(): MutableList<Oveja> {
        var ovejas: MutableList<Oveja> = ArrayList()
        ovejas.add(Oveja("1", "Aldo", "Hembra",  Calendar.getInstance().time,15 ))
        ovejas.add(Oveja("2", "Lila", "Macho",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("3", "Luciana", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("4", "Daniel", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("6", "Aldo", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("7", "Lila", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("8", "Luciana", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("9", "Daniel", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("10", "Aldo", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("11", "Lila", "Macho",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("12", "Luciana", "Hembra",  Calendar.getInstance().time,15))
        ovejas.add(Oveja("13", "Daniel", "Hembra",  Calendar.getInstance().time,15))
        return ovejas
    }
}