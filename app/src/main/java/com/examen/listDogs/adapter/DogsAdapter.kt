package com.examen.listDogs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.codesgood.views.JustifiedTextView
import com.examen.listDogs.R
import com.examen.listDogs.data.model.Dog
import org.w3c.dom.Text

class DogsAdapter(val listDogs: List<Dog>, val context: Context): RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameDog = itemView.findViewById<TextView>(R.id.nameDog)
        val ageDog = itemView. findViewById<TextView>(R.id.ageDog)
        val description = itemView.findViewById<JustifiedTextView>(R.id.descriptionDog)
        val image = itemView.findViewById<ImageView>(R.id.imageView)

        fun render(itemDog: Dog, context: Context){
            nameDog.setText(itemDog.dogName)
            ageDog.setText("Almost ${itemDog.age} years")
            description.setText(itemDog.description)

            Glide.with(context).load(itemDog.image).apply(RequestOptions.bitmapTransform( RoundedCorners(20))).into(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.adapter_dogs,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.render(listDogs[position], context)
    }

    override fun getItemCount(): Int =  listDogs.size



}