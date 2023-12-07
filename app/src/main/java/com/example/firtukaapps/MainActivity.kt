package com.example.firtukaapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firtukaapps.data.Glasses
import com.example.firtukaapps.data.ListGlassesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var rvGlasses: RecyclerView
    private val list = ArrayList<Glasses>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGlasses = findViewById(R.id.rv_glasses)
        rvGlasses.setHasFixedSize(true)

        list.addAll(getListGlasses())
        showRecyclerList()
    }
    private fun getListGlasses(): ArrayList<Glasses> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Glasses>()
        for (i in dataName.indices) {
            val hero = Glasses(dataName[i], dataType[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvGlasses.layoutManager = LinearLayoutManager(this)
        val listGlassesAdapter = ListGlassesAdapter(list)
        rvGlasses.adapter = listGlassesAdapter
    }
}