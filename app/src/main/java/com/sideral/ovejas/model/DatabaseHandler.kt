package com.sideral.ovejas.model


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper( context,DB_NAME, factory, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object{
        private  val DB_NAME = "OVEJASDB"
        private  val DB_VERSION = 1
        //TABLA OVEJAS
        private val OVEJAS_TABLE_NAME = "OVEJAS"
        val OVEJAS_ID_COLUMN = "ID"
        val OVEJAS_PESO_COLUMN = "PESO"
        val OVEJAS_FECHA_NAC_COLUMN = "FECHA_NACIMIENTO"
        val OVEJAS_PROPIETARIO_COLUMN = "PROPIETARIO_ID"
        val OVEJAS_MADRE_COLUMN = "OBJETAS_ID"
        val OVEJAS_ESTADO = "ESTADO"

        //TABLA PROPIETARIIOS
        val PROPIETARIOS_TABLE_NAME = "PROPIETARIOS"
        val PROPIETARIOS_ID_COLUMN = "ID"
        val PROPIETARIOS_NOMBRE_COLUMN = "NOMBRE"

        //TABLA OVEJAS MOVIMIENTOS
        val MOVIMIENTOS_TABLE_NAME = "MOVIMIENTOS"
        val MOVIMIENTOS_ID_COLUMN_= "ID"
        val MOVIMIENTOS_FECHA_COLUMN = "FECHA"
        val MOVIMIENTOS_DESCRIPCION = "DESCRIPCION"

    }
}