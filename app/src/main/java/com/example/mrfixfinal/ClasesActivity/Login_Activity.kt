package com.example.mrfixfinal.ClasesActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.R
import com.example.mrfixfinal.Objetos.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.regex.Pattern

class Login_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        initEvents()
        }

    fun initEvents(){
        val button : Button = findViewById<Button>(R.id.button2)
        val btniniciar: Button = findViewById<Button>(R.id.button)
        val btnProduc : Button = findViewById(R.id.btnprod)
        button.setOnClickListener{
            val intent = Intent(this, registrarse_activity::class.java)
            startActivity(intent)
        }
        btniniciar.setOnClickListener{
            find()
        }
        btnProduc.setOnClickListener{
            val intent = Intent(this@Login_Activity, Productos_Activity::class.java)
            startActivity(intent)
        }
    }


    fun find(){
        val correo: EditText = findViewById(R.id.correoEdit)
        val contra: EditText = findViewById(R.id.contraEdit)

        var correotex: String = correo.text.toString()
        var contratext: String = contra.text.toString()



            var call: Call<User> = RetrofitClient.getInstance().getAPI().userLogin(correotex,contratext)

            call.enqueue(object: Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    try {
                        println(response)
                        if(response.isSuccessful){
                            var usuario: User = response.body()!!
                            val intent = Intent(this@Login_Activity, Inicio::class.java)
                            intent.putExtra("id",usuario.getIDCliente())
                            intent.putExtra("nombre",usuario.getNombreCliente())
                            intent.putExtra("apepat",usuario.getApePatCliente())
                            startActivity(intent)

                        }
                    }catch (ex: Exception){

                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("on","onfailure")
                    Toast.makeText(this@Login_Activity,"El correo o contraseña introducidos son incorrectos",Toast.LENGTH_LONG).show()
                }
            })



    }



    }


























