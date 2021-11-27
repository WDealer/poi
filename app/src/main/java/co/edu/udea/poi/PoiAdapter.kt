package co.edu.udea.poi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PoiAdapter(
    private val poiList:ArrayList<POIItem>
    ): RecyclerView.Adapter<PoiAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poi=poiList[position]
        holder.bind(poi)

    }

    override fun getItemCount(): Int = poiList.size



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private var startsTextView: TextView = itemView.findViewById(R.id.stars_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        fun bind(poi:POIItem){
            nameTextView.text = poi.site
            descriptionTextView.text = poi.description
            startsTextView.text = poi.stars
            Picasso.get().load(poi.image).into(pictureImageView)




        }

    }
}