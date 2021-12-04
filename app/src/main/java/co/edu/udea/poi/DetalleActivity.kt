package co.edu.udea.poi

import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.poi.databinding.ActivityDetalleBinding
import co.edu.udea.poi.model.POIItem
import com.squareup.picasso.Picasso
import java.io.Serializable


class DetalleActivity:AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate (saveInstanceState)

        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val poi: POIItem = intent.extras?.getSerializable("poi") as POIItem
        with(detalleBinding){
            nameTextView.text = poi.site
            descriptionTextView.text = poi.description
            starsTextView.text = poi.stars
            Picasso.get().load(poi.image).into(pictureImageView)
        }

    }

}
