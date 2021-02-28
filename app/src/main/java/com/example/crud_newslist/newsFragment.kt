import android.os.Bundle
import com.example.crud_newslist.NewsAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_newslist.R
import com.example.crud_newslist.News
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.news_fragment.*


abstract class newsFragment : Fragment(), NewsAdapter.NewsHolder.ClickListener {
    private lateinit var news: MutableList<News>
    private val adapter = NewsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listNews.layoutManager = LinearLayoutManager(context)
        listNews.adapter = adapter

        btnAdd.setOnClickListener {
            val aux = News("Prueba", "Prueba", "http://i.imgur.com/DvpvklR.png")
            adapter.addItem(aux)
        }

        getItems()
        adapter.setItems(news)
    }

    private fun getItems() {
        news = mutableListOf(
            News(
                "Pérdidas en el sector",
                "Millones de pérdidas",
                "http://gtpreviene.researchmobile.co:3000/uploads/2ij5og5sq62uidkz_maquila.jpg"
            ),

            News("Cacif presenta recurso", "Millones de pérdidas", "http://gtpreviene.researchmobile.co:3000/uploads/co1dcqyh7toc3vkq_cien-billetes.jpg")
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
            "Actualizado",
            "http://gtpreviene.researchmobile.co:3000/uploads/clh4lmsqs9xk5uah_juanito.jpeg"
        )

        adapter.updateItem(position, aux)

        return true
    }
}