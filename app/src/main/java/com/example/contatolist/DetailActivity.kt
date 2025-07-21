package com.example.contatolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contatolist.databinding.ActivityDetailBinding
import com.example.contatolist.models.Contato


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contato = intent.getParcelableExtra<Contato>("contato")
        binding.textViewDetail.text = contato?.name ?: "Contato não encontrado"
    }
}