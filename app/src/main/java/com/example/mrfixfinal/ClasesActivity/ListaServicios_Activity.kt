package com.example.mrfixfinal.ClasesActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfixfinal.API.RetrofitClient
import com.example.mrfixfinal.Adapters.CustomAdapter
import com.example.mrfixfinal.Adapters.CustomAdapterServicio
import com.example.mrfixfinal.Objetos.Detalle
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ListaServicios_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_servicios)
        mostrarHistorial()
    }

    fun mostrarHistorial(){
        //TRAER LOS SERVICIOS
        val bundle: Bundle? = intent.extras
        val id:String = bundle?.getString("id")!!
        var call: Call<List<Detalle>> = RetrofitClient.getInstance().getAPI().getDetalleVehiculos(id)
        call.enqueue(object: Callback<List<Detalle>> {
            override fun onResponse(call: Call<List<Detalle>>, response: Response<List<Detalle>>) {
                try {
                    if(response.isSuccessful){
                        var Detalles = response.body()!!
                        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                        val adapter = CustomAdapterServicio(Detalles)
                        recyclerView.layoutManager = LinearLayoutManager(this@ListaServicios_Activity)
                        recyclerView.adapter = adapter
                        adapter.setOnItemClickListener(object: CustomAdapterServicio.onItemClickListener{
                            override fun onItemClick(position: Int) {

                            }

                        })
                        //println(productos[0].getNombreProducto())
                        //var listAdapter: ListAdapter = ListAdapter(productos,this@Productos_Activity)
                        //var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                        //recyclerView.setHasFixedSize(true)
                        //recyclerView.layoutManager = LinearLayoutManager(this@Productos_Activity)
                        //recyclerView.adapter = listAdapter
                    }
                }catch (ex: Exception){
                    println("No trao nada gemte")
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<List<Detalle>>, t: Throwable) {
                Log.i("on","onfailure")
                println("error")
            }
        })
        //FIN DE TRAER LOS PRODUCTOS
    }
}