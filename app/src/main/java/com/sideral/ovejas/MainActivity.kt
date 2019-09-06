package com.sideral.ovejas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){

        mRecyclerView = findViewById(R.id.rvOvejasList)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getOvejas(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getOvejas(): MutableList<Ovejas>{
        var ovejas: MutableList<Ovejas> = ArrayList()
        ovejas.add(Ovejas("1","Aldo","foto1.jpg"))
        ovejas.add(Ovejas("2","Lila","foto2.jpg"))
        ovejas.add(Ovejas("3","Luciana","foto3.jpg"))
        ovejas.add(Ovejas("4","Daniel","foto4.jpg"))
        return ovejas
    }
}
