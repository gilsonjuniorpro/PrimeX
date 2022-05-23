package primex.ca.data.repository

import primex.ca.data.remote.APIService
import primex.ca.data.remote.response.GenreResponse
import primex.ca.util.FilmType
import primex.ca.util.Resource
import java.lang.Exception
import javax.inject.Inject

class GenreRepository @Inject constructor(private val api: APIService) {
    suspend fun getMoviesGenre(filmType: FilmType): Resource<GenreResponse> {
        val response = try {
            if (filmType == FilmType.MOVIE) api.getMovieGenres() else api.getTvShowGenres()
        } catch (e: Exception){
            return Resource.Error("Unknown error occurred!")
        }
        return Resource.Success(response)
    }
}
