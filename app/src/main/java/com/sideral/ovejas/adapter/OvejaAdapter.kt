package com.sideral.ovejas.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.sideral.ovejas.R
import com.sideral.ovejas.activity.DetalleOveja
import com.sideral.ovejas.entity.Item
import com.sideral.ovejas.entity.TipoItem
import com.sideral.ovejas.model.EditaOvejaModelImp
import com.sideral.ovejas.presenter.EditaOvejaPresenterImp
import com.sideral.ovejas.view.ViewHolder
import kotlinx.android.synthetic.main.activity_detalle_oveja.view.*


class OvejaAdapter : RecyclerView.Adapter<ViewHolder>() {
    private var mDefaultSpanCount: Int = 0
    private var mItemsList: MutableList<Item> = ArrayList()


    fun RecyclerAdapter(items: MutableList<Item>, gridLayoutManager: GridLayoutManager, defaultSpan: Int){
        this.mItemsList = items
        this.mDefaultSpanCount = defaultSpan
        val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (isHeaderType(position)) defaultSpan else 1
            }
        }

        gridLayoutManager.spanSizeLookup = spanSizeLookup

    }

    private fun isHeaderType(position: Int): Boolean {
        return (mItemsList.get(position).getItemType()== TipoItem().HEADER_ITEM_TYPE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View
        if (viewType == TipoItem().HEADER_ITEM_TYPE){
            view = LayoutInflater.from(parent.context).inflate(R.layout.header_type_layout,parent,false)
        }else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.grid_type_layout,parent,false)
        }
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return mItemsList.get(position).getItemType()
        //ovejas.get(position).ge
    }

    override fun getItemCount(): Int {
        return mItemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mItemsList.get(position)
        if (isHeaderType(position)){
            bindHeaderItem(holder, position)
        } else{
            bindGridItem(holder, position)
        }

        //holder.bind(item, context)
    }

    private fun bindGridItem(holder: ViewHolder, position: Int) {
        val container = holder.itemView
        val title = container.findViewById<TextView>(R.id.gridTitle)
        title.text = mItemsList[position].mItemTitle

        container.setOnClickListener { v -> val intent = Intent(v.context.applicationContext, DetalleOveja::class.java)
            var id =mItemsList[position].mItemTitle.toInt()
            intent.putExtra("item", id)
            v.context.startActivity(intent)}

    }

    private fun mostrarMensaje(v: View, mensaje: String){
        Toast.makeText(v.context, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun bindHeaderItem(holder: ViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.headerTitle)
        textView.text = mItemsList.get(position).mItemTitle
    }

    fun addItem(item: Item){
        mItemsList.add(item)
    }

    fun removeItem(item: Item){
        mItemsList.remove(item)
    }




}



