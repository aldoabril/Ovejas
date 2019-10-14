package com.sideral.ovejas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.adapter.OvejaAdapter
import com.sideral.ovejas.entity.*
import com.sideral.ovejas.model.DatabaseHandler
import com.sideral.ovejas.model.EditaOvejaModelImp
import com.sideral.ovejas.model.OvejaModel
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.presenter.OvejaPresenter
import com.sideral.ovejas.view.OvejaView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), OvejaView.Lista {
    private val dbHandler = DatabaseHandler(this)
    private val mOvejaPresenter = ListaOvejasPresenterImp(this, dbHandler )
    private val DEFAULT_SPAN_COUNT: Int=5
    lateinit var mRecyclerView : RecyclerView
    lateinit var mToolbar: Toolbar
    val mAdapter : OvejaAdapter = OvejaAdapter()
    val mItemList: MutableList<Item> = ArrayList()


    override fun mostrarOvejas() {
        var item: Item
        var ovejas = mOvejaPresenter.getOvejas()
        ovejas.sortBy { it.propietario.idPropietario }
        var propietario = Propietario()
        for (o in ovejas){
            if (!o.propietario.idPropietario.equals(propietario.idPropietario)) {
                item = HeaderItem("${o.propietario.nombre}")
                mItemList.add(item)
            }
            item = GridItem("${o.idOveja}")
            mItemList.add(item)
            Log.d("Propietario", propietario.nombre)
            propietario = o.propietario
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){

        mRecyclerView = findViewById(R.id.rvOvejasList)
        mRecyclerView.setHasFixedSize(true)
        //mToolbar = findViewById(R.id.toolbar)
        mRecyclerView.setRecycledViewPool(RecyclerView.RecycledViewPool())
        val gridLayoutManager = GridLayoutManager(this, DEFAULT_SPAN_COUNT)
        mRecyclerView.layoutManager = gridLayoutManager
        mAdapter.RecyclerAdapter(mItemList, gridLayoutManager, DEFAULT_SPAN_COUNT)
        mRecyclerView.adapter = mAdapter
        mostrarOvejas()
    }


}
