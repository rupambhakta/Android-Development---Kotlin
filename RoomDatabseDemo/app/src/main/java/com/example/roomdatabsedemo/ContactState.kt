package com.example.roomdatabsedemo

data class ContactState(
    val contact: List<Contact> = emptyList(),
    val firstName:String="",
    val lastname:String="",
    val phoneNumber:String="",
    val isAddingContact:Boolean=false,
    val sortType: SortType = SortType.FIRST_NAME
)
