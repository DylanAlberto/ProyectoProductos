package com.example.project3cm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id= intent.getStringExtra("id")

        val queue = Volley.newRequestQueue(this)
        val url = getString(R.string.urlDescription) + id
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                if (response != null) {
                    Picasso.get().load(response.getString("imag_url")).into(ivDetail);
                    tvNameDetail.text = response.getString("name")
                    tvDescriptionDetail.text = response.getString("desc")
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this,
                    error.toString(),
                    Toast.LENGTH_LONG).show()
            }
        )

        queue.add(jsonObjectRequest)
    }
}
