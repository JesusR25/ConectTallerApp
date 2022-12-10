package com.example.mrfixfinal.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.Objetos.Vehiculo
import com.example.mrfixfinal.R


class CustomAdapterVehiculos (var lista:MutableList<Vehiculo>): RecyclerView.Adapter<CustomAdapterVehiculos.ViewHolder>() {

    private lateinit var mListener: onItemClickListener
    private var ID: String = ""

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun traerID(i: Int): List<String>{
        val list_detalle = listOf<String>(lista[i].IDVehiculo)
        return list_detalle
    }


    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_vehiculos,viewGroup,false)
        return ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.nombre.text = lista[i].NombreVehiculo
        viewHolder.modelo.text = lista[i].ModeloVehiculo
        viewHolder.imagen.setImageResource(R.drawable.car)

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val nombre:TextView
        val modelo: TextView
        val imagen: ImageView
        init {
            nombre = itemView.findViewById(R.id.nombre_vehiculo)
            modelo = itemView.findViewById(R.id.modelo_vehiculo)
            imagen = itemView.findViewById(R.id.item_carro)
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}