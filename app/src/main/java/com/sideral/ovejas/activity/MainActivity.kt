package com.sideral.ovejas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.adapter.RecyclerAdapter
import com.sideral.ovejas.entity.GridItem
import com.sideral.ovejas.entity.HeaderItem
import com.sideral.ovejas.entity.Item
import com.sideral.ovejas.entity.Oveja
import com.sideral.ovejas.model.ImpOvejaModel
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val DEFAULT_SPAN_COUNT: Int=5
    lateinit var mRecyclerView : RecyclerView
    lateinit var mToolbar: Toolbar
    val mAdapter : RecyclerAdapter =
        RecyclerAdapter()

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
        addMockList()
    }

    private fun addMockList() {
        var item: Item
        var ovejas = ImpOvejaModel().getOvejas()
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
        /*for (i in 1..200){
            if (i%20==0 || i==1){
                item = HeaderItem("Header $i")
            }else{
                item = GridItem("Grid $i")
            }
            mItemList.add(item)
        }*/

    }


}
