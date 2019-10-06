package com.sideral.ovejas.entity

class HeaderItem(title: String) : Item(title){
    override fun getItemType(): Int{
        return TipoItem().HEADER_ITEM_TYPE;
    }
}