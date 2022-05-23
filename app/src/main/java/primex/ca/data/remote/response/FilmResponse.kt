package primex.ca.data.remote.response

import com.google.gson.annotations.SerializedName
import primex.ca.model.Film

data class FilmResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Film>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
