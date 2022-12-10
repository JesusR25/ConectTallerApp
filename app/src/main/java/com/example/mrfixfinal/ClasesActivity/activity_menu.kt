package com.example.mrfixfinal.ClasesActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.Objetos.Detalle
import com.example.mrfixfinal.Objetos.User
import com.example.mrfixfinal.Objetos.Vehiculo
import com.example.mrfixfinal.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class activity_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initComponents()
    }

    fun initComponents(){
        val btnBuscar: Button = findViewById<Button>(R.id.btnBuscar)
        val token: EditText = findViewById(R.id.editToken)
        if(token.getText().toString().trim().equals("")){
            token.setError("No puede estar el campo en blanco")
        }
            btnBuscar.setOnClickListener{
                buscarServicio()
            }

    }

    fun buscarServicio(){
        println("Entro")
        val token: EditText = findViewById(R.id.editToken)
        val est: TextView = findViewById(R.id.txtEstatus)

        val observacion: TextView = findViewById(R.id.txtObser)
        val mecanico: TextView = findViewById(R.id.txtMecanico)

        val linear: LinearLayout = findViewById(R.id.linearDatos)
        val tokenTex: String = token.text.toString()
        println(tokenTex)
        var call: Call<Detalle> = RetrofitClient.getInstance().getAPI().getDetalle(tokenTex)
        call.enqueue(object: Callback<Detalle> {
            override fun onResponse(call: Call<Detalle>, response: Response<Detalle>) {
                try {
                    if(response.isSuccessful){
                        var detalle: Detalle = response.body()!!
                        est.setText(detalle.Estatus)
                        observacion.setText("Observacion: " + detalle.Observaciones)
                        mecanico.setText("Mecanico: " + detalle.Mecanico)
                        traerVehiculo(detalle.IDVehiculo)

                        //Aqui se obtiene los datos que se guardan en el objeto detalle de arriba
                    }
                }catch (ex: Exception){
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<Detalle>, t: Throwable) {
                Log.i("on","onfailure")
                println(t.message)
                Toast.makeText(this@activity_menu,"El token no se ha encontrado.",
                    Toast.LENGTH_LONG).show()
            }
        })
    }

    fun traerVehiculo(idVe: String){
        val vehi: TextView = findViewById(R.id.txtVehiculo)
        var call: Call<Vehiculo> = RetrofitClient.getInstance().getAPI().getVehiculo(idVe)
        call.enqueue(object: Callback<Vehiculo> {
            override fun onResponse(call: Call<Vehiculo>, response: Response<Vehiculo>) {
                try {
                    if(response.isSuccessful){
                        var vehiculo: Vehiculo = response.body()!!
                        vehi.setText(vehiculo.MarcaVehiculo + " " + vehiculo.ModeloVehiculo )

                        //Aqui se obtiene los datos que se guardan en el objeto detalle de arriba
                    }
                }catch (ex: Exception){
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<Vehiculo>, t: Throwable) {
                Log.i("on","onfailure")
                println(t.message)
                Toast.makeText(this@activity_menu,"El correo o contraseña introducidos son incorrectos",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}