package com.sideral.ovejas.entity

class GridItem(title: String) : Item(title) {
    override fun getItemType(): Int {
        return TipoItem().GRID_ITEM_TYPE;
    }


}