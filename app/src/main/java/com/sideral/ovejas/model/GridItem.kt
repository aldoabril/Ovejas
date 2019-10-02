package com.sideral.ovejas.model

class GridItem(title: String) : Item(title) {
    override fun getItemType(): Int {
        return GRID_ITEM_TYPE;
    }


}