package primex.ca.data.remote.response

import com.google.gson.annotations.SerializedName
import primex.ca.model.Genre

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)
