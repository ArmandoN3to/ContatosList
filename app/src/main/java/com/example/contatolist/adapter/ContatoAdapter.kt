package com.example.contatolist.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contatolist.databinding.ItemContatoBinding
import com.example.contatolist.models.Contato
import com.example.contatolist.R

class ContatoAdapter(
    private var contatoList: List<Contato>,
    private val onClick: (Contato) -> Unit
) : RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>() {

    inner class ContatoViewHolder(val binding: ItemContatoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val binding = ItemContatoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContatoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = contatoList[position]

        holder.binding.textViewName.text = contato.name
        holder.binding.textViewPhone.text = contato.phone

        // Trata o ByteArray para Bitmap ou usa placeholder
        val photoBytes = contato.photo
        if (photoBytes != null) {
            val bitmap = BitmapFactory.decodeByteArray(photoBytes, 0, photoBytes.size)
            holder.binding.imageViewPhoto.setImageBitmap(bitmap)
        } else {
            holder.binding.imageViewPhoto.setImageResource(R.drawable.ic_launcher_foreground)
        }

        holder.binding.root.setOnClickListener {
            onClick(contato)
        }

    }

    override fun getItemCount() = contatoList.size

    fun updateList(novaLista: List<Contato>) {
        contatoList = novaLista
        notifyDataSetChanged()
    }
}
