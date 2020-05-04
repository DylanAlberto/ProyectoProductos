package com.example.project2cm

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val brands = resources.getStringArray(R.array.Brands)
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, brands)
        spBrand.adapter = adapter
        val carsList = ArrayList<Car>()

        btnSave.setOnClickListener {
            if (tvModel.text.isEmpty() || tvModel.text.isBlank() || tvYear.text.isEmpty() || tvYear.text.isBlank()) Toast.makeText(this, R.string.error1, Toast.LENGTH_SHORT).show()
            else if (tvYear.text.length < 4) Toast.makeText(this, R.string.error2, Toast.LENGTH_SHORT).show()
            else {
                val newCarr = Car ()
                newCarr.brand = spBrand.selectedItem.toString()
                newCarr.model = tvModel.text.toString()
                newCarr.year = tvYear.text.toString()
                when(newCarr.brand){
                    "Toyota" -> newCarr.image = (R.drawable.t_logo)
                    "Volkswagen" -> newCarr.image = (R.drawable.vw_logo)
                    "Nissan" -> newCarr.image = (R.drawable.n_logo)
                    else -> newCarr.image = (R.drawable.c_logo)
                }
                carsList.add(newCarr)
                Toast.makeText(this, R.string.ok, Toast.LENGTH_SHORT).show()
            }
        }
        btnList.setOnClickListener{
            val i = Intent()
            i.setClass(this, list::class.java)
            i.putParcelableArrayListExtra("arraylist", carsList);
            startActivity(i)
        }
    }
}
class Car() : Parcelable{
    var brand: String? = null
    var model: String? = null
    var year: String? = null
    var image: Int = 0

    constructor(parcel: Parcel) : this() {
        brand = parcel.readString()
        model = parcel.readString()
        year = parcel.readString()
        image = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(model)
        parcel.writeString(year)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }
}
