package com.example.mrfixfinal.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfixfinal.Objetos.Detalle
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.R
import org.w3c.dom.Text

class CustomAdapterServicio (val lista:List<Detalle>): RecyclerView.Adapter<CustomAdapterServicio.ViewHolder>() {
    private lateinit var mListener: onItemClickListener
    private var ID: String = ""

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun traerID(i: Int): List<String>{
        val list_detalle = listOf<String>(lista[i].IDReparacion,lista[i].IDVenta, lista[i].Estatus,lista[i].Observaciones,lista[i].TipoServicio, lista[i].IDVehiculo, lista[i].Vehiculo, lista[i].Mecanico)
        return list_detalle
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_servicios,viewGroup,false)
        return ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.token.text = lista[i].IDReparacion
        viewHolder.estatus.text = lista[i].Estatus
        viewHolder.observacion.text = lista[i].Observaciones
        viewHolder.mecanico.text = lista[i].Mecanico
        //ID = lista[i].idProducto
        viewHolder.imagen.setImageResource(R.drawable.services)

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val token:TextView
        val estatus: TextView
        val mecanico: TextView
        val observacion: TextView
        val imagen: ImageView

        init {
            token = itemView.findViewById(R.id.token)
            estatus = itemView.findViewById(R.id.estatus)
            imagen = itemView.findViewById(R.id.item_serv)
            mecanico = itemView.findViewById(R.id.mec)
            observacion = itemView.findViewById(R.id.observacion)
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}