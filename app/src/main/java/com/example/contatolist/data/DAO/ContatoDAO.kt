package com.example.contatolist.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contatolist.data.Entity.ContatoEntity
import com.example.contatolist.models.Contato
import kotlinx.coroutines.flow.Flow

@Dao
interface ContatoDAO {
//    @Insert suspend fun inserirContato(contato: ContatoEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirContato(contato: ContatoEntity):
    @Query("SELECT * FROM contatos") fun listarContatos(): Flow<List<ContatoEntity>>
    @Query("SELECT * FROM contatos WHERE id= :id") suspend fun buscarContatoPorId(id:Int): ContatoEntity?

}