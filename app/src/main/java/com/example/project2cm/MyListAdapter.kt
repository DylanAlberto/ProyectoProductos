package com.example.project2cm

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter(var mCtx:Context , var resource:Int,var items:ArrayList<Car>)
    :ArrayAdapter<Car>( mCtx , resource , items ){




    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView :ImageView = view.findViewById(R.id.iconIv)
        var textView : TextView = view.findViewById(R.id.titleTv)
        var textView1 : TextView = view.findViewById(R.id.descTv)


        var person : Car = items[position]

        imageView.setImageResource(person.image)
        textView.text = person.model
        textView1.text = person.year


        return view
    }

}