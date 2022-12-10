package com.example.mrfixfinal.ClasesActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.mrfixfinal.R

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        initEvents()
    }

    fun initEvents(){
        val bundle: Bundle? = intent.extras
        val id:String = bundle?.getString("id")!!
        val nombre:String = bundle?.getString("nombre")!!
        val apepat:String = bundle?.getString("apepat")!!
        val cajaTexto:TextView = findViewById(R.id.title_view)
        cajaTexto.setText("Bienvenido de nuevo \n" + nombre + " " + apepat)

        val cardToken:CardView = findViewById(R.id.cardToken)
        val cardProductos:CardView = findViewById(R.id.cardProductos)
        val cardHistorial:CardView = findViewById(R.id.cardHistorial)
        val cardPerfil:CardView = findViewById(R.id.cardPerfil)
        //Evento para cardToken
        cardToken.setOnClickListener{
            val intent =  Intent(this, activity_menu::class.java)
            startActivity(intent)
        }
        //Evento para cardProductos
        cardProductos.setOnClickListener{
            val intent2 =  Intent(this, Productos_Activity::class.java)
            startActivity(intent2)
        }
        //Evento para cardHistorial
        cardHistorial.setOnClickListener{
            val intent =  Intent(this, activity_listavehiculos::class.java)
            intent.putExtra("idcliente", id)
            startActivity(intent)
        }
        //Evento para cardPerfil
        cardPerfil.setOnClickListener{
            val intent =  Intent(this, activity_informacion::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }

    }


}