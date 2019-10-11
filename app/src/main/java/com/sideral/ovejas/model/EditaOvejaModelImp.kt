package com.sideral.ovejas.model

import android.database.Cursor
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.presenter.OvejaPresenter
import java.time.temporal.TemporalQueries.localDate
import java.util.*
import kotlin.collections.ArrayList

class EditaOvejaModelImp: OvejaModel.EditaOveja {

    val mEditaOvejaPresenterImp : OvejaPresenter.EditaOveja
    var mDbHandler: DatabaseHandler



    constructor(ovejaModel: OvejaPresenter.EditaOveja, dbHandler: DatabaseHandler)  {
        mEditaOvejaPresenterImp = ovejaModel
        mDbHandler = dbHandler
    }

    override fun getOveja(idOveja: Int): Oveja {
        val c: Cursor? = mDbHandler.getOveja(idOveja)
        var oveja = Oveja()
        if (c!!.moveToFirst()){
            while(!c.isAfterLast){
                var idOveja = c.getInt(c.getColumnIndex(DatabaseHandler.OVEJAS_ID_COLUMN))
                var propietario = c.getString(c.getColumnIndex(DatabaseHandler.PROPIETARIOS_NOMBRE_COLUMN))
                var peso = c.getDouble(c.getColumnIndex(DatabaseHandler.OVEJAS_PESO_COLUMN))
                var fechaNac = c.getString(c.getColumnIndex(DatabaseHandler.OVEJAS_FECHA_NAC_COLUMN))
                var sexo = c.getString(c.getColumnIndex(DatabaseHandler.OVEJAS_SEXO))
                oveja.idOveja = idOveja
                oveja.propietario = propietario
                oveja.fechaNacimiento = Calendar.getInstance().time
                oveja.peso = peso
                oveja.sexo =  sexo
                c.moveToNext()
            }
        }
        c.close()
        return oveja
    }

    override fun borrar(idOveja: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun guardar(oveja: Oveja) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}