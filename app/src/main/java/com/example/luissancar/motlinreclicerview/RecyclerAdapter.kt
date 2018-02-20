package com.example.luissancar.motlinreclicerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

/**
 * Created by luissancar on 20/2/18.
 */
/////////////////////////
class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var guitars: MutableList<Guitars>  = ArrayList()
    lateinit var context:Context

    fun RecyclerAdapter(guitars : MutableList<Guitars>, context: Context){
        this.guitars = guitars
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = guitars.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_guitars_list, parent, false))
    }

    override fun getItemCount(): Int {
        return guitars.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val guitarMarca = view.findViewById(R.id.tvMarca) as TextView
        val modelo = view.findViewById(R.id.tvModelo) as TextView
        val photo = view.findViewById(R.id.ivGuitar) as ImageView

        fun bind(guitars:Guitars, context: Context){
            guitarMarca.text = guitars.marca+" "
            modelo.text = guitars.modelo
            photo.loadUrl(guitars.photo)
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, guitars.marca, Toast.LENGTH_SHORT).show() })
        }
        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}