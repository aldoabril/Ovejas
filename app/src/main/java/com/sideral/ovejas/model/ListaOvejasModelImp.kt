package com.sideral.ovejas.model

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sideral.ovejas.entity.Oveja
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
        var oveja = Oveja()
        if (c!!.moveToFirst()){
            while(!c.isAfterLast){
                var idOveja = c.getInt(c.getColumnIndex(DatabaseHandler.OVEJAS_ID_COLUMN))
                var propietario = c.getString(c.getColumnIndex(DatabaseHandler.PROPIETARIOS_NOMBRE_COLUMN))
                var peso = c.getDouble(c.getColumnIndex(DatabaseHandler.OVEJAS_PESO_COLUMN))
                //var fechaNac = c.getString(c.getColumnIndex(DatabaseHandler.OVEJAS_FECHA_NAC_COLUMN))
                var sexo = c.getString(c.getColumnIndex(DatabaseHandler.OVEJAS_SEXO))
                oveja.idOveja = idOveja
                oveja.propietario = propietario
                oveja.fechaNacimiento = Calendar.getInstance().time;
                oveja.peso = peso
                oveja.sexo =  sexo
                ovejas.add(oveja)

                c.moveToNext()
            }
        }
        c.close()
        return ovejas
    }
}