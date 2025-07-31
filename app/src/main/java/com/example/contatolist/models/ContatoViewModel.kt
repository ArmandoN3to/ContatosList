package com.example.contatolist.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {

    private val _contatos = MutableLiveData<MutableList<Contato>>().apply {
        value = mutableListOf(
        )
    }

    val contatos: LiveData<MutableList<Contato>> = _contatos

    fun adicionarContato(novoContato: Contato) {
        val listaAtual = _contatos.value ?: mutableListOf()
        listaAtual.add(novoContato)
        _contatos.value = listaAtual
    }
}
