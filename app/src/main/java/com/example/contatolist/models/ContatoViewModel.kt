package com.example.contatolist.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {

    private val _contatos = MutableLiveData<MutableList<Contato>>().apply {
        value = mutableListOf(
            Contato("Anna Silva", "+55 11 98765-4321", "anna@email.com", null, null),
            Contato("Carlos Ferreira", "+55 11 99888-1234", "carlos@email.com", null, "Amigo de trabalho"),
            Contato("Maria Oliveira", "+55 11 97654-3210", null, null, null),
            Contato("João Costa", "+55 11 96543-2109", "joao@email.com", null, "Primo")
        )
    }

    val contatos: LiveData<MutableList<Contato>> = _contatos

    fun adicionarContato(novoContato: Contato) {
        val listaAtual = _contatos.value ?: mutableListOf()
        listaAtual.add(novoContato)
        _contatos.value = listaAtual
    }
}
