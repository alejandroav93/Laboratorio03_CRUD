package com.example.crud_newslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<News> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias.add(News("Prueba","https://www.adslzone.net/app/uploads-adslzone.net/2019/04/borrar-fondo-imagen-930x487.jpg"))

        val adapter: NewsAdapter = NewsAdapter(noticias)

        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)
            listaNoticias.layoutManager = LinearLayoutManager(this)
            listaNoticias.adapter = adapter




    }
}