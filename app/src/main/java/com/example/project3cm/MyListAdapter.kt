package com.example.project3cm

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyListAdapter(var mCtx:Context , var resource:Int,var items:ArrayList<Product>)
    :ArrayAdapter<Product>( mCtx , resource , items ){




    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView :ImageView = view.findViewById(R.id.iconIv)
        val tvname : TextView = view.findViewById(R.id.tvName)
        var tvProvider : TextView = view.findViewById(R.id.tvProvider)
        var tvPrice : TextView = view.findViewById(R.id.tvPrice)
        var tvDelivery : TextView = view.findViewById(R.id.tvDelivery)


        var product : Product = items[position]

        Picasso.get().load(product.image).into(imageView);
        tvname.text = product.name
        tvProvider.text = product.provider
        tvPrice.text = "Precio:" + product.price
        tvDelivery.text = "Envío:" + product.delivery


        return view
    }

}