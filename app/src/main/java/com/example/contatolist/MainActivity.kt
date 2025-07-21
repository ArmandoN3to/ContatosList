package com.example.contatolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contatolist.adapter.ContatoAdapter
import com.example.contatolist.databinding.ActivityMainBinding
import com.example.contatolist.models.Contato
import com.example.contatolist.models.ContatoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContatoAdapter

    private val contatoViewModel: ContatoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ContatoAdapter(emptyList()) { contato ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }

        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewContacts.adapter = adapter

        // Observa LiveData
        contatoViewModel.contatos.observe(this) { listaAtual ->
            adapter.updateList(listaAtual)
        }

        binding.fabAddContact.setOnClickListener {
            val intent = Intent(this, AddContatoActivity::class.java)
            startActivityForResult(intent, 200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            val novoContato = data?.getParcelableExtra<Contato>("novo_contato")
            novoContato?.let {
                contatoViewModel.adicionarContato(it)
            }
        }
    }
}
