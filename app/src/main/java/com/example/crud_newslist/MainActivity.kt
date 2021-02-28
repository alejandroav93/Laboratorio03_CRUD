package com.example.crud_newslist

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NewsAdapter.NewsHolder.ClickListener {
    private var noticias: MutableList<News> = mutableListOf()
    private val adapter = NewsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticias.layoutManager = LinearLayoutManager(this)
        listaNoticias.adapter = adapter

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{

            val aux = News("Prueba","https://www.adslzone.net/app/uploads-adslzone.net/2019/04/borrar-fondo-imagen-930x487.jpg")
            adapter.addItem(aux)
        }

    }

    private fun getItems() {
        noticias = mutableListOf(
            News(
                "Juego de Super Mario",

                "https://www.adslzone.net/app/uploads-adslzone.net/2019/04/borrar-fondo-imagen-930x487.jpg\""
            ),

            News("Juego de Super Mario",  "https://www.adslzone.net/app/uploads-adslzone.net/2019/04/borrar-fondo-imagen-930x487.jpg\"")
        )

        /*for (a in news) {
        }*/
    }
    override fun onItemClicked(position: Int) {
        adapter.removeItem(position)
    }

    override fun onItemLongClicked(position: Int): Boolean {
        val aux = News(
                "Actualizado",

                "http://gtpreviene.researchmobile.co:3000/uploads/clh4lmsqs9xk5uah_juanito.jpeg"
        )
        adapter.updateItem(position, aux)

        return true
    }
}
