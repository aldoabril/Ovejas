package com.sideral.ovejas.model

class GridItem(title: String) : Item(title) {
    override fun getItemType(): Int {
        return TipoItem().GRID_ITEM_TYPE;
    }


}