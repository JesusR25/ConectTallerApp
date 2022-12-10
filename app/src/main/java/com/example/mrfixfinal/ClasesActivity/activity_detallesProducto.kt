package com.example.mrfixfinal.ClasesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.mrfixfinal.R

class activity_detallesProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_producto)
        mostrar()
    }

    fun mostrar(){
        val bundle: Bundle? = intent.extras
        val nombre: TextView = findViewById(R.id.titulo)
        val marca: TextView = findViewById(R.id.marca)
        val detalle: TextView = findViewById(R.id.descripcion)
        val precio: TextView = findViewById(R.id.precio)

        //Poner texto
        val nombretex = bundle?.getString("nombre")!!
        val marcatex = bundle?.getString("marca")!!
        val detalletex = bundle?.getString("detalle")!!
        val preciotex = bundle?.getString("precio")!!

        nombre.setText(nombretex)
        marca.setText(marcatex)
        detalle.setText(detalletex)
        precio.setText(preciotex)
        println(nombretex)
    }
}