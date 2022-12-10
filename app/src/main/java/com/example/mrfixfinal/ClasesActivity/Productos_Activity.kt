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
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class Productos_Activity : AppCompatActivity(){
    var listaRet: MutableList<Producto> = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        mostrarProductos()

    }





    fun mostrarProductos(){
        var reciente: Button = findViewById(R.id.btnReciente)
        var desc: Button = findViewById(R.id.btnDescendente)
        var asc: Button = findViewById(R.id.btnAscendente)
        var alfa: Button = findViewById(R.id.btnAlfa)
        //TRAER TODOS LOS PRODUCTOS
        var call: Call<List<Producto>> = RetrofitClient.getInstance().getAPI().getProductos()
        call.enqueue(object: Callback<List<Producto>>{
            override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                try {
                    if(response.isSuccessful){
                        var productos = response.body()!!
                        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                        val adapter = CustomAdapter(productos as MutableList<Producto>)
                        recyclerView.layoutManager = LinearLayoutManager(this@Productos_Activity)
                        recyclerView.adapter = adapter
                        adapter.setOnItemClickListener(object: CustomAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val intent = Intent(this@Productos_Activity, activity_detallesProducto::class.java)
                                val listadet = adapter.traerID(position)
                                intent.putExtra("id", listadet[0])
                                intent.putExtra("nombre", listadet[1])
                                intent.putExtra("marca", listadet[2])
                                intent.putExtra("detalle", listadet[3])
                                intent.putExtra("precio", listadet[4])
                                startActivity(intent)
                            }

                        })
                        //BOTONES
                        alfa.setOnClickListener{
                            adapter.vaciarLista()
                            adapter.notifyDataSetChanged()
                            var call: Call<List<Producto>> = RetrofitClient.getInstance().getAPI().getProdAlfa()
                            call.enqueue(object: Callback<List<Producto>>{
                                override fun onResponse(call: Call <List<Producto>>, response: Response<List<Producto>>) {
                                    try {
                                        if(response.isSuccessful){
                                            listaRet = (response.body() as MutableList<Producto>?)!!
                                            if (listaRet.isNotEmpty()){
                                                println("entre")
                                                adapter.asignarListaReciente(listaRet)
                                                adapter.notifyDataSetChanged()
                                            }

                                        }
                                    }catch (ex: Exception){
                                        println("No trao nada gemte")
                                        Log.i("Error ex","exception")
                                    }
                                }

                                override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                                    Log.i("on","onfailure")
                                    println("error")
                                }
                            })
                        }
                        reciente.setOnClickListener{
                            adapter.vaciarLista()
                            adapter.notifyDataSetChanged()
                            var call: Call<List<Producto>> = RetrofitClient.getInstance().getAPI().getProductos()
                            call.enqueue(object: Callback<List<Producto>>{
                                override fun onResponse(call: Call <List<Producto>>, response: Response<List<Producto>>) {
                                    try {
                                        if(response.isSuccessful){
                                            listaRet = (response.body() as MutableList<Producto>?)!!

                                            listaRet = listaRet.asReversed()
                                            if (listaRet.isNotEmpty()){
                                                adapter.asignarListaReciente(listaRet)
                                                adapter.notifyDataSetChanged()
                                            }

                                        }
                                    }catch (ex: Exception){
                                        println("No trao nada gemte")
                                        Log.i("Error ex","exception")
                                    }
                                }

                                override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                                    Log.i("on","onfailure")
                                    println("error")
                                }
                            })

                        }
                        desc.setOnClickListener{
                            adapter.vaciarLista()
                            adapter.notifyDataSetChanged()
                            var call: Call<List<Producto>> = RetrofitClient.getInstance().getAPI().getProdDesc()
                            call.enqueue(object: Callback<List<Producto>>{
                                override fun onResponse(call: Call <List<Producto>>, response: Response<List<Producto>>) {
                                    try {
                                        if(response.isSuccessful){
                                            listaRet = (response.body() as MutableList<Producto>?)!!
                                            if (listaRet.isNotEmpty()){
                                                adapter.asignarListaReciente(listaRet)
                                                adapter.notifyDataSetChanged()
                                            }

                                        }
                                    }catch (ex: Exception){
                                        println("No trao nada gemte")
                                        Log.i("Error ex","exception")
                                    }
                                }

                                override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                                    Log.i("on","onfailure")
                                    println("error")
                                }
                            })
                        }
                        //UN SOLO BOTON
                        asc.setOnClickListener{
                            adapter.vaciarLista()
                            adapter.notifyDataSetChanged()
                            var call: Call<List<Producto>> = RetrofitClient.getInstance().getAPI().getProdAsc()
                            call.enqueue(object: Callback<List<Producto>>{
                                override fun onResponse(call: Call <List<Producto>>, response: Response<List<Producto>>) {
                                    try {
                                        if(response.isSuccessful){
                                            listaRet = (response.body() as MutableList<Producto>?)!!
                                            if (listaRet.isNotEmpty()){
                                                adapter.asignarListaReciente(listaRet)
                                                adapter.notifyDataSetChanged()
                                            }

                                        }
                                    }catch (ex: Exception){
                                        println("No trao nada gemte")
                                        Log.i("Error ex","exception")
                                    }
                                }

                                override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                                    Log.i("on","onfailure")
                                    println("error")
                                }
                            })

                        }
                        //TERMINA BOTON
                    }
                }catch (ex: Exception){
                    println("No trao nada gemte")
                    Log.i("Error ex","exception")
                }
            }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Log.i("on","onfailure")
                println("error")
            }
        })
        //FIN DE TRAER LOS PRODUCTOS
    }
}


