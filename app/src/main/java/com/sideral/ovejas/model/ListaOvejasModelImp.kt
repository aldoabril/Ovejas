package com.sideral.ovejas.model

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.entity.Propietario
import com.sideral.ovejas.presenter.OvejaPresenter
import java.util.*
import kotlin.collections.ArrayList

class ListaOvejasModelImp: OvejaModel.ListaOveja {
    val mListaOvejasPresenterImp : OvejaPresenter.ListaOveja
    var mDbHandler: DatabaseHandler

    constructor(ovejaPresenter: OvejaPresenter.ListaOveja,dbHandler: DatabaseHandler){
        mListaOvejasPresenterImp = ovejaPresenter
        mDbHandler = dbHandler
    }

    override fun getOvejas(): MutableList<Oveja> {
        val c: Cursor? = mDbHandler.getOvejas()
        var ovejas: MutableList<Oveja> = ArrayList()


        if (c!!.moveToFirst()){
            while(!c.isAfterLast){
                var idOveja = c.getInt(c.getColumnIndex( DatabaseHandler.OVEJAS_ID_COLUMN))
                var idPropietario = c.getInt(c.getColumnIndex(DatabaseHandler.OVEJAS_PROPIETARIO_COLUMN))
                var nombrePropietario = c.getString(c.getColumnIndex(DatabaseHandler.PROPIETARIOS_NOMBRE_COLUMN))
                var propietario = Propietario()
                propietario.idPropietario = idPropietario
                propietario.nombre = nombrePropietario
                var oveja = Oveja()
                oveja.idOveja = idOveja
                oveja.propietario = propietario
                ovejas.add(oveja)

                c.moveToNext()
            }
        }
        c.close()
        return ovejas
    }
}