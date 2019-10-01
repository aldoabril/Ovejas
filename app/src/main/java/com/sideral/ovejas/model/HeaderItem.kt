package com.sideral.ovejas.model

class HeaderItem(title: String) : Item(title){
    override fun getItemType(): Short{
        return HEADER_ITEM_TYPE;
    }
}