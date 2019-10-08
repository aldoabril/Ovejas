package com.sideral.ovejas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.adapter.OvejaAdapter
import com.sideral.ovejas.entity.GridItem
import com.sideral.ovejas.entity.HeaderItem
import com.sideral.ovejas.entity.Item
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.EditaOvejaModelImp
import com.sideral.ovejas.model.OvejaModel
import com.sideral.ovejas.presenter.ListaOvejasPresenterImp
import com.sideral.ovejas.presenter.OvejaPresenter
import com.sideral.ovejas.view.OvejaView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), OvejaView.Lista {

    private val mOvejaPresenter = ListaOvejasPresenterImp(this)

    override fun mostrarOvejas() {
        var item: Item
        var ovejas = mOvejaPresenter.getOvejas()
        ovejas.sortBy { it.propietario }
        var propietario: String =""
        for (o in ovejas){
            if (!o.propietario.equals(propietario))
                item = HeaderItem("${o.propietario}")
            else
                item = GridItem("${o.idOveja}")
            mItemList.add(item)
            propietario = o.propietario
        }
    }



    private val DEFAULT_SPAN_COUNT: Int=5
    lateinit var mRecyclerView : RecyclerView
    lateinit var mToolbar: Toolbar
    val mAdapter : OvejaAdapter =
        OvejaAdapter()

    val mItemList: MutableList<Item> = ArrayList()


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
