package com.sideral.ovejas.entity

abstract class Item(title: String) {

    var mItemTitle = title

    abstract fun getItemType(): Int

}