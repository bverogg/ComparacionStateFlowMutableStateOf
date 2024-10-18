package com.bverog.comparacionstateflowmutablestateof.ui.viewmodel

import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow



class MessageViewModel : ViewModel(){

    // mutableStateOf para manejar el estado de un mensaje
    //Esta palabra clave declara una variable mutable. Esto significa que puedes cambiar su valor
    // después de haberlo asignado inicialmente.
    var mutableStateOfMessage = mutableStateOf("")
        private set
    // StateFlow para manejar el estado de otro mensaje
    private val _stateFlowMessage = MutableStateFlow("")
    // es una variable de solo lectura
    val stateFlowMessage: StateFlow<String> = _stateFlowMessage

    // Actualizar mutableStateOf
    fun updateMutableStateOfMessage(newMessage: String) {
        mutableStateOfMessage.value = newMessage
    }

    // Actualizar StateFlow
    fun updateStateFlowMessage(newMessage: String) {
        _stateFlowMessage.value = newMessage
    }
}