package co.edu.udea.poi.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class POIItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("stars")
    val stars: String,
    @SerializedName("url")
    val url: String
) :Serializable