package com.example.project2cm


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
        val arraylist: ArrayList<Car> = extras!!.getParcelableArrayList("arraylist")!!

        listView.adapter = MyListAdapter(this,R.layout.row,arraylist)
    }
}
