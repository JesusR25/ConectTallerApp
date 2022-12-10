package com.example.mrfixfinal.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfixfinal.Objetos.Producto
import com.example.mrfixfinal.R


class CustomAdapter (var lista:MutableList<Producto>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener
    private var ID: String = ""

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun traerID(i: Int): List<String>{
        val list_detalle = listOf<String>(lista[i].idProducto,lista[i].marcaProducto, lista[i].nombreProducto,lista[i].descripcionProducto,"$" + lista[i].precioProducto)
        return list_detalle
    }

    fun vaciarLista(){
        lista.clear()
    }

    fun asignarListaReciente(lisAsc: List<Producto>){
        lista = lisAsc as MutableList<Producto>
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.nombre.text = lista[i].nombreProducto
        viewHolder.detalle.text = lista[i].descripcionProducto
        viewHolder.precio.text = "$" + lista[i].precioProducto
        ID = lista[i].idProducto
        viewHolder.imagen.setImageResource(R.drawable.prod)

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val nombre:TextView
        val detalle: TextView
        val imagen: ImageView
        val precio: TextView

        init {
            precio = itemView.findViewById(R.id.precio)
            nombre = itemView.findViewById(R.id.titulo_producto)
            detalle = itemView.findViewById(R.id.detalle_producto)
            imagen = itemView.findViewById(R.id.item_image)
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}