package com.sideral.ovejas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.adapter.RecyclerAdapter
import com.sideral.ovejas.model.GridItem
import com.sideral.ovejas.model.HeaderItem
import com.sideral.ovejas.model.Item
import com.sideral.ovejas.model.Ovejas
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
        var ovejas = getOvejas()

        for (i in 1..200){
            if (i%20==0 || i==1){
                item = HeaderItem("Header $i")
            }else{
                item = GridItem("Grid $i")
            }
            mItemList.add(item)
        }
        
    }

    fun getOvejas(): MutableList<Ovejas>{
        var ovejas: MutableList<Ovejas> = ArrayList()
        ovejas.add(Ovejas("1", "Aldo", "Hembra"))
        ovejas.add(Ovejas("2", "Lila", "Macho"))
        ovejas.add(Ovejas("3", "Luciana", "Hembra"))
        ovejas.add(Ovejas("4", "Daniel", "Hembra"))
        ovejas.add(Ovejas("6", "Aldo", "Hembra"))
        ovejas.add(Ovejas("7", "Lila", "Hembra"))
        ovejas.add(Ovejas("8", "Luciana", "Hembra"))
        ovejas.add(Ovejas("9", "Daniel", "Hembra"))
        ovejas.add(Ovejas("10", "Aldo", "Hembra"))
        ovejas.add(Ovejas("11", "Lila", "Macho"))
        ovejas.add(Ovejas("12", "Luciana", "Hembra"))
        ovejas.add(Ovejas("13", "Daniel", "Hembra"))
        return ovejas
    }
}
