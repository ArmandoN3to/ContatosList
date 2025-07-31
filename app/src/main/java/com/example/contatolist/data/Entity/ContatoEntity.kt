package com.example.contatolist.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contatos")
data class ContatoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String,
    val email: String?,
    val photo: ByteArray?,
    var notes: String?
)


