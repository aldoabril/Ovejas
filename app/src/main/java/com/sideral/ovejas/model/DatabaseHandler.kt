package com.sideral.ovejas.model


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception
import kotlin.math.log
import kotlin.random.Random

class DatabaseHandler(context: Context): SQLiteOpenHelper( context,DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        crearTablaOvejas(db)
        crearTablaPropietaros(db)
        crearTablaOvejaMovimientos(db)
        crearTablaTipoMovimientos(db)
        crearTablaEstados(db)
        incializaPropietarios(db)
        inicializaOvejas(db)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS '" + OVEJAS_TABLE_NAME + "'");
        db!!.execSQL("DROP TABLE IF EXISTS '" + PROPIETARIOS_TABLE_NAME + "'");
        db!!.execSQL("DROP TABLE IF EXISTS '" + TIPOMOV_TABLE_NAME + "'");
        db!!.execSQL("DROP TABLE IF EXISTS '" + ESTADOS_TABLE_NAME + "'");
        onCreate(db)

    }

    fun getOvejas(): Cursor? {
        val db = this.readableDatabase
        lateinit var c: Cursor
        try {
          c= db.rawQuery("SELECT $OVEJAS_TABLE_NAME.$OVEJAS_ID_COLUMN," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_PROPIETARIO_COLUMN," +
                    "$PROPIETARIOS_TABLE_NAME.$PROPIETARIOS_NOMBRE_COLUMN" +
                    " FROM $OVEJAS_TABLE_NAME, $PROPIETARIOS_TABLE_NAME" +
                    " WHERE $OVEJAS_TABLE_NAME.$OVEJAS_PROPIETARIO_COLUMN = $PROPIETARIOS_TABLE_NAME.$PROPIETARIOS_ID_COLUMN", null)

        } catch (e: Exception){
            Log.d("MENSAJE",e.message)
        }
        return c
    }

    fun getOveja(idOveja: Int):Cursor?{
        val db = this.readableDatabase
        lateinit var c: Cursor
        try {
            val arguments = mutableListOf<String>()
            arguments.add(idOveja.toString())
            c = db.rawQuery("SELECT $OVEJAS_TABLE_NAME.$OVEJAS_ID_COLUMN," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_PROPIETARIO_COLUMN," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_FECHA_NAC_COLUMN," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_PESO_COLUMN," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_SEXO," +
                    "$OVEJAS_TABLE_NAME.$OVEJAS_MADRE_COLUMN," +
                    "$PROPIETARIOS_TABLE_NAME.$PROPIETARIOS_NOMBRE_COLUMN" +
                     " FROM $OVEJAS_TABLE_NAME, $PROPIETARIOS_TABLE_NAME" +
                     " WHERE $OVEJAS_TABLE_NAME.$OVEJAS_PROPIETARIO_COLUMN = $PROPIETARIOS_TABLE_NAME.$PROPIETARIOS_ID_COLUMN" +
                     " AND $OVEJAS_TABLE_NAME.$OVEJAS_ID_COLUMN = $idOveja", null)

        } catch (e: Exception){
            Log.d("MENSAJE",e.message)
        }
        return c
    }

    fun crearTablaOvejas(db: SQLiteDatabase?){
        val CREATE_OVEJAS_TABLE = ("CREATE TABLE " +
                OVEJAS_TABLE_NAME + "("
                + OVEJAS_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + OVEJAS_PESO_COLUMN + " NUMERIC,"
                + OVEJAS_FECHA_NAC_COLUMN +" DATE,"
                + OVEJAS_PROPIETARIO_COLUMN + " INTEGER,"
                + OVEJAS_ESTADO + " TEXT,"
                + OVEJAS_SEXO + " TEXT,"
                + OVEJAS_MADRE_COLUMN + " INTEGER"+")")

            db!!.execSQL(CREATE_OVEJAS_TABLE)
            Log.d("tabla",OVEJAS_TABLE_NAME)

    }

    fun crearTablaPropietaros(db: SQLiteDatabase?){
        val CREATE_PROPIETARIOS_TABLE = ("CREATE TABLE " +
                PROPIETARIOS_TABLE_NAME + "("
                + PROPIETARIOS_ID_COLUMN + " INTEGER PRIMARY KEY,"
                + PROPIETARIOS_NOMBRE_COLUMN + " TEXT,"
                + PROPIETARIOS_ESTADO_COLUMN +" TEXT" +")")

        db!!.execSQL(CREATE_PROPIETARIOS_TABLE)
        Log.d("tabla",PROPIETARIOS_TABLE_NAME)

    }

    fun crearTablaOvejaMovimientos(db: SQLiteDatabase?){
        val CREATE_TABLE_MOVIMIENTOS = ("CREATE TABLE " +
                MOVIMIENTOS_TABLE_NAME + "("
                + MOVIMIENTOS_ID_COLUMN + " INTEGER PRIMARY KEY,"
                + MOVIMIENTOS_FECHA_COLUMN + " DATE,"
                + MOVIMIENTOS_DESCRIPCION +" TEXT,"
                + MOVIMIENTOS_TIPO_COLUMN +" TEXT,"
                + MOVIMIENTOS_ESTADO_COLUMN +" TEXT"+")")

        db!!.execSQL(CREATE_TABLE_MOVIMIENTOS)
        Log.d("tabla",MOVIMIENTOS_TABLE_NAME)


    }

    fun crearTablaTipoMovimientos(db: SQLiteDatabase?){
        val CREATE_TABLE_TIPO_MOVIMIENTOS = ("CREATE TABLE " +
                TIPOMOV_TABLE_NAME + "("
                + TIPOMOV_ID_COLUMN + " INTEGER PRIMARY KEY,"
                + TIPOMOV_DESCRIPCION_COLUMN +" TEXT,"
                + TIPOMOV_ESTADO_COLUMN +" TEXT"+")")

        db!!.execSQL(CREATE_TABLE_TIPO_MOVIMIENTOS)
        Log.d("tabla",TIPOMOV_TABLE_NAME)


    }

    fun crearTablaEstados(db: SQLiteDatabase?){
        val CREATE_TABLE_ESTADOS = ("CREATE TABLE " +
                ESTADOS_TABLE_NAME + "("
                + ESTADOS_ID_COLUMN + " INTEGER PRIMARY KEY,"
                + ESTADOS_DESCRIPCION_COLUMN +" TEXT"+")")

        db!!.execSQL(CREATE_TABLE_ESTADOS)
        Log.d("tabla",ESTADOS_TABLE_NAME)


    }

    fun inicializaOvejas(db: SQLiteDatabase?) {
        lateinit var values: Any
        var propietario: Int = 0
        var peso: Double
        for (i in 1..100){
            peso = Random.nextDouble(40.100)
            when (i){
                in 1..40 -> propietario =1
                in 41..51 -> propietario = 2
                in 52..61 -> propietario = 3
                in 62..72 -> propietario = 4
                in 73..100 -> propietario = 2
            }
            values =  ContentValues()
            values.put(OVEJAS_PESO_COLUMN,peso)
            values.put(OVEJAS_FECHA_NAC_COLUMN,"2019/10/09")
            values.put(OVEJAS_PROPIETARIO_COLUMN,propietario)
            //values.put(OVEJAS_MADRE_COLUMN,1)
            values.put(OVEJAS_ESTADO,1)
            values.put(OVEJAS_SEXO,"M")
            db!!.insert(OVEJAS_TABLE_NAME,null, values)
            values.clear()
        }



    }

    fun incializaPropietarios(db: SQLiteDatabase?) {
        var values =  ContentValues()
        values.put(PROPIETARIOS_NOMBRE_COLUMN,"Alonso")
        values.put(PROPIETARIOS_ESTADO_COLUMN,"V")
        db!!.insert(PROPIETARIOS_TABLE_NAME,null, values)
        values.clear()
        values =  ContentValues()
        values.put(PROPIETARIOS_NOMBRE_COLUMN,"Lila")
        values.put(PROPIETARIOS_ESTADO_COLUMN,"V")
        db!!.insert(PROPIETARIOS_TABLE_NAME,null, values)
        values.clear()
        values =  ContentValues()
        values.put(PROPIETARIOS_NOMBRE_COLUMN,"Raquel")
        values.put(PROPIETARIOS_ESTADO_COLUMN,"V")
        db!!.insert(PROPIETARIOS_TABLE_NAME,null, values)
        values.clear()

        values =  ContentValues()
        values.put(PROPIETARIOS_NOMBRE_COLUMN,"Jasmine")
        values.put(PROPIETARIOS_ESTADO_COLUMN,"V")
        db!!.insert(PROPIETARIOS_TABLE_NAME,null, values)


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
        val OVEJAS_SEXO = "SEXO"

        //TABLA PROPIETARIIOS
        val PROPIETARIOS_TABLE_NAME = "PROPIETARIOS"
        val PROPIETARIOS_ID_COLUMN = "ID"
        val PROPIETARIOS_NOMBRE_COLUMN = "NOMBRE"
        val PROPIETARIOS_ESTADO_COLUMN = "ESTADO"

        //TABLA OVEJAS MOVIMIENTOS
        val MOVIMIENTOS_TABLE_NAME = "MOVIMIENTOS"
        val MOVIMIENTOS_ID_COLUMN = "ID"
        val MOVIMIENTOS_FECHA_COLUMN = "FECHA"
        val MOVIMIENTOS_DESCRIPCION = "DESCRIPCION"
        val MOVIMIENTOS_TIPO_COLUMN = "TIPOMOV_ID"
        val MOVIMIENTOS_ESTADO_COLUMN = "ESTADO"

        //TABLA TIPO MOVIMIENTOS
        val TIPOMOV_TABLE_NAME = "TIPOMOV"
        val TIPOMOV_ID_COLUMN = "ID"
        val TIPOMOV_DESCRIPCION_COLUMN = "DESCRIPCION"
        val TIPOMOV_ESTADO_COLUMN = "ESTADO"


        //TABLA ESTADOS
        val ESTADOS_TABLE_NAME = "ESTADOS"
        val ESTADOS_ID_COLUMN = "ID"
        val ESTADOS_DESCRIPCION_COLUMN = "DESCRIPCION"


    }
    var companion = Companion
}