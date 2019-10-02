package com.sideral.ovejas.model

abstract class Item(title: String) {

    var mItemTitle = title

    abstract fun getItemType(): Int

}