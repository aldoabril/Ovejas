package com.sideral.ovejas.model

class HeaderItem(title: String) : Item(title){
    override fun getItemType(): Int{
        return TipoItem().HEADER_ITEM_TYPE;
    }
}