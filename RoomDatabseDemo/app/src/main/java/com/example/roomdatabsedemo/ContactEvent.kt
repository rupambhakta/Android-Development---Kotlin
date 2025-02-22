package com.example.roomdatabsedemo

sealed interface ContactEvent{
    object SaveContact: ContactEvent
    data class SetFirstname(val firstName:String):ContactEvent
    data class SetLastname(val LastName:String):ContactEvent
    data class SetPhoneNumber(val phoneNumber:String):ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent
    data class SortContacts(val sortType: SortType):ContactEvent
    data class DeleteContact(val contact: Contact):ContactEvent
}