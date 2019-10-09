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

    }
}