package com.example.contatolist

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contatolist.databinding.ActivityAddContatoBinding
import com.example.contatolist.models.Contato
import java.io.ByteArrayOutputStream

class AddContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddContatoBinding
    private var photoByteArray: ByteArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewAddPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phone = binding.editTextPhone.text.toString()
            val email = binding.editTextEmail.text.toString()
            val notes = binding.editTextNotes.text.toString()

            if (name.isNotBlank() && phone.isNotBlank()) {
                val contato = Contato(
                    name = name,
                    phone = phone,
                    email = if (email.isNotBlank()) email else null,
                    photo = photoByteArray,
                    notes = if (notes.isNotBlank()) notes else null
                )

                val resultIntent = Intent()
                resultIntent.putExtra("novo_contato", contato)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                // Você pode mostrar um Toast aqui se quiser
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            val uri = data?.data ?: return
            val inputStream = contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            binding.imageViewAddPhoto.setImageBitmap(bitmap)

            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            photoByteArray = stream.toByteArray()
        }
    }
}
