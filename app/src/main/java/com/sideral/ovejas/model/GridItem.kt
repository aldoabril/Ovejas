package com.sideral.ovejas.model

class GridItem(title: String) : Item(title) {
    override fun getItemType(): Short {
        return GRID_ITEM_TYPE;
    }


}