package com.sideral.ovejas.model

abstract class Item(title: String) {
    var HEADER_ITEM_TYPE : Short = 0
    var GRID_ITEM_TYPE : Short = 1
    var mItemTitle = title

    abstract fun getItemType(): Short

}