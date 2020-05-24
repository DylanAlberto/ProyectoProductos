package com.example.project3cm


import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity



class list : AppCompatActivity() {

    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        listView = findViewById(R.id.listView)
        val extras = intent.extras
        val arraylist: ArrayList<Product> = extras!!.getParcelableArrayList("arraylist")!!

        listView.adapter = MyListAdapter(this,R.layout.row,arraylist)
        listView.setOnItemClickListener { parent, view, position, id ->
            var myItem = parent.getItemAtPosition(position) as Product
            val i1 = Intent()
            i1.setClass(this, detail::class.java)
            i1.putExtra("id", myItem.id);
            startActivity(i1)
        }
    }
}
