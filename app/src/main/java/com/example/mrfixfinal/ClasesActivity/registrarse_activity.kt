package com.example.mrfixfinal.ClasesActivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.regex.Pattern


class registrarse_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        initEvents()

    }

    fun initEvents(){
        val button : Button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            registerUser()
        }
    }

    fun registerUser(){
        val nombreEdit: EditText = findViewById<EditText?>(R.id.editTextNombre)
        val apepatEdit: EditText = findViewById(R.id.editTextApellidoPaterno)
        val apematEdit: EditText = findViewById(R.id.editTextApellidoMaterno)
        val celularEdit: EditText = findViewById(R.id.editTextCelular)
        val correoEdit: EditText = findViewById(R.id.editTextCorreo)
        val contraEdit: EditText = findViewById(R.id.editTextContraseña)
        var nombre = nombreEdit.text.toString()
        var apepat = apepatEdit.text.toString()
        var apemat = apematEdit.text.toString()
        var celular = celularEdit.text.toString()
        var correo = correoEdit.text.toString()
        var contra = contraEdit.text.toString()

            var call: Call<ResponseBody> = RetrofitClient
                .getInstance().getAPI().createUser(nombre, apepat, apemat, correo,celular,nombre,contra)

            call.enqueue(object : Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
                        var body:String = response.body()!!.string()

                        Toast.makeText(this@registrarse_activity, body,Toast.LENGTH_LONG).show()
                    } catch (e: IOException){
                        e.printStackTrace()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@registrarse_activity, t.message, Toast.LENGTH_LONG).show()
                }
            })

    }



}

