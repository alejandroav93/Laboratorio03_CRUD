package com.example.crud_newslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias. add("Prueba 1")
        noticias. add("Prueba 2")
        noticias. add("Prueba 3")
        noticias. add("Prueba 4")
        noticias. add("Prueba 5")


        noticias.removeAt(2)

        noticias[0] = "Elemento"


        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)

    }
}