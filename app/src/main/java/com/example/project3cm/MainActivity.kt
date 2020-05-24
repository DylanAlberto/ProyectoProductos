package com.example.project3cm

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()
        val queue = Volley.newRequestQueue(this)
        val url = getString(R.string.urlProducts)
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                if (response != null) {
                    for (i in 0 until response.length()) {
                        val newProduct = Product ()
                        val object1: JSONObject = response.getJSONObject(i)
                        newProduct.id = object1.getString("id");
                        newProduct.name = object1.getString("name");
                        newProduct.provider = object1.getString("provider")
                        newProduct.price = object1.getString("price")
                        newProduct.delivery = object1.getString("delivery")
                        newProduct.image = object1.getString("thumbnail_url")
                        products.add(newProduct)
                    }
                    val i1 = Intent()
                    i1.setClass(this, list::class.java)
                    i1.putParcelableArrayListExtra("arraylist", products);
                    startActivity(i1)
                }
            },
            Response.ErrorListener { _ ->
            }
        )

        queue.add(jsonObjectRequest)
    }
}
class Product() : Parcelable{
    var id: String? = null
    var name: String? = null
    var provider: String? = null
    var price: String? = null
    var delivery: String? = null
    var image: String? = null


    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        provider = parcel.readString()
        price = parcel.readString()
        delivery = parcel.readString()
        image = parcel.readString()

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(provider)
        parcel.writeString(price)
        parcel.writeString(delivery)
        parcel.writeString(image)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
