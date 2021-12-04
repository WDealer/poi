package co.edu.udea.poi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.poi.model.POI
import co.edu.udea.poi.model.POIItem
import com.google.gson.Gson

class ListPoiActivity : AppCompatActivity() {

    private lateinit var listPoi:ArrayList<POIItem>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        //listPoi = createMockpoi()
        listPoi = loadJson()
        poiAdapter = PoiAdapter(listPoi,onItemClicked = {onPoiClicked(it)})

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }



    }

    private fun onPoiClicked(poi: POIItem) {
        Log.d("lugar",poi.site)
        val intent = Intent(this,DetalleActivity::class.java)
        intent.putExtra("poi",poi)
        startActivity(intent)

    }

    private fun loadJson(): ArrayList<POIItem> {

        var poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(poiString, POI::class.java)
        return data





    }

    /*private fun createMockpoi(): ArrayList<POI>{
        return  arrayListOf(
            POI(site="Conservatorio",
            description = "es una escuela musical situada en Ibagué",
            stars = "Puntuacion:4.5",
            urlPicture = "https://www.ciudadeducacion.com/wp-content/uploads/2015/04/2024_kikokairuz-conservatorio-patio-1.jpg"),
            POI(site="Museo de artes",
            description = "es uno de los más activos museos regionales de Colombia",
            stars = "Puntuacion:4.8",
            urlPicture = "https://upload.wikimedia.org/wikipedia/commons/a/a5/Museo_de_Arte_del_Tolima_116.jpg"),
            POI(site="Parque de la musica",
            description = "Una fuente luminosa que se activa al ritmo de la música",
            stars = "Puntuacion:4.5",
            urlPicture = "https://elturismoencolombia.com/wp-content/uploads/2018/07/ibague_parque_musica_tolima_colombia_travel.jpg")
        )





    }*/

}