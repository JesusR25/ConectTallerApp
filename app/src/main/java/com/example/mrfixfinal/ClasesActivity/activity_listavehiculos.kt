package com.example.mrfixfinal.ClasesActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.Adapters.CustomAdapter
import com.example.mrfixfinal.Adapters.CustomAdapterVehiculos
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.Objetos.Vehiculo
import com.example.mrfixfinal.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class activity_listavehiculos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listavehiculos)
        mostrarVehiculos()
    }

    fun mostrarVehiculos(){
        //TRAER TODOS LOS VEHICULOS
        val bundle: Bundle? = intent.extras
        val id:String = bundle?.getString("idcliente")!!
        var call: Call<List<Vehiculo>> = RetrofitClient.getInstance().getAPI().getVehiculosCliente(id)
        call.enqueue(object: Callback<List<Vehiculo>> {
            override fun onResponse(call: Call<List<Vehiculo>>, response: Response<List<Vehiculo>>) {
                try {
                    if(response.isSuccessful){
                        var vehicu = response.body()!!
                        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                        val adapter = CustomAdapterVehiculos(vehicu as MutableList<Vehiculo>)
                        recyclerView.layoutManager = LinearLayoutManager(this@activity_listavehiculos)
                        recyclerView.adapter = adapter
                        adapter.setOnItemClickListener(object: CustomAdapterVehiculos.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val intent = Intent(this@activity_listavehiculos, ListaServicios_Activity::class.java)
                                val listadet = adapter.traerID(position)
                                intent.putExtra("id", listadet[0])
                                startActivity(intent)
                            }

                        })
                        //TERMINA BOTON
                    }
                }catch (ex: Exception){
                    println("No trao nada gemte")
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<List<Vehiculo>>, t: Throwable) {
                Log.i("on","onfailure")
                println("error")
            }
        })
        //FIN DE TRAER LOS PRODUCTOS
    }
}