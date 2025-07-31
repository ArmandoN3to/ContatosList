package com.example.contatolist.data.Repository

import com.example.contatolist.data.DAO.ContatoDAO
import com.example.contatolist.data.Entity.ContatoEntity
import kotlinx.coroutines.flow.Flow

class ContatoRepository(private val dao: ContatoDAO) {
    suspend fun inserirContato(contatoEntity: ContatoEntity) = dao.inserirContato(contatoEntity)
    fun listarContato(): Flow<List<ContatoEntity>> = dao.listarContatos()
}