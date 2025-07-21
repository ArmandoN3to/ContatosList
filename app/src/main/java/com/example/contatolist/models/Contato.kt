package com.example.contatolist.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// @Parcelize permite que o Android passe objetos desta classe entre componentes (como Activities)
// de forma eficiente. É como "empacotar" o objeto para viagem.
@Parcelize
data class Contato(
    val name: String,
    val phone: String,
    val email: String?,
    val photo: ByteArray?,
    var notes: String?
) : Parcelable

