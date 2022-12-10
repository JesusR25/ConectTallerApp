package com.example.mrfixfinal.ClasesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.R
import com.example.mrfixfinal.Objetos.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class activity_informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        initComponents()
        obtenerCliente()
    }

    fun initComponents(){
        val button:Button = findViewById(R.id.btnVolver)
        button.setOnClickListener{
            finish()
        }
    }


    fun obtenerCliente(){
        val nombre:TextView = findViewById(R.id.textNombre)
        val correo:TextView = findViewById(R.id.textCorreo)
        val telefono:TextView = findViewById(R.id.textTelefono)
        val usu:TextView= findViewById(R.id.textUsuario)
        val bundle: Bundle? = intent.extras
        val id:String = bundle?.getString("id")!!
        var call: Call<User> = RetrofitClient.getInstance().getAPI().getUser(id)
        call.enqueue(object: Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                try {
                    if(response.isSuccessful){
                        var usuario: User = response.body()!!
                        nombre.setText(usuario.getNombreCliente() + " " + usuario.getApePatCliente() + " " + usuario.getApeMatCliente())
                        correo.setText(usuario.getCorreoCliente())
                        telefono.setText(usuario.getTelefonoCliente())
                        usu.setText(usuario.getUsuario())
                    }
                }catch (ex: Exception){
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.i("on","onfailure")
                Toast.makeText(this@activity_informacion,"El correo o contraseña introducidos son incorrectos",Toast.LENGTH_LONG).show()
            }
        })
    }
}