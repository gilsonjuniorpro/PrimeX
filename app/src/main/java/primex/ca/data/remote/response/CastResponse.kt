package primex.ca.data.remote.response

import com.google.gson.annotations.SerializedName
import primex.ca.model.Cast

data class CastResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val castResult: List<Cast>
)
