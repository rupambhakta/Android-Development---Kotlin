package com.example.roomdatabsedemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ContactViewModel(
    private val dao: ContactDao
    ):ViewModel() {
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _state = MutableStateFlow(ContactState())

    suspend fun onEvent(event: ContactEvent){
        when(event){
            is ContactEvent.DeleteContact -> {
               dao.deleteContact(event.contact)
            }
            ContactEvent.HideDialog -> {
                _state.update {
                    it.copy(isAddingContact = false)
                }
            }
            ContactEvent.SaveContact -> {

            }
            is ContactEvent.SetFirstname -> TODO()
            is ContactEvent.SetLastname -> TODO()
            is ContactEvent.SetPhoneNumber -> TODO()
            ContactEvent.ShowDialog -> TODO()
            is ContactEvent.SortContacts -> TODO()
        }
    }
}