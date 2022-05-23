package primex.ca.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import primex.ca.data.remote.APIService
import primex.ca.data.remote.response.CastResponse
import primex.ca.model.Film
import primex.ca.paging.*
import primex.ca.util.FilmType
import primex.ca.util.Resource
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val api: APIService
) {
    fun getTrendingFilms(filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                TrendingFilmSource(api = api, filmType)
            }
        ).flow
    }

    fun getPopularFilms(filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                PopularFilmSource(api = api, filmType)
            }
        ).flow
    }

    fun getTopRatedFilm(filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                TopRatedFilmSource(api = api, filmType)
            }
        ).flow
    }

    fun getNowPlayingFilms(filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                NowPlayingFilmSource(api = api, filmType)
            }
        ).flow
    }

    fun getUpcomingTvShows(): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                UpcomingFilmSource(api = api)
            }
        ).flow
    }

    fun getBackInTheDaysFilms(filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                BackInTheDaysFilmSource(api = api, filmType)
            }
        ).flow
    }

    fun getSimilarFilms(movieId: Int, filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                SimilarFilmSource(api = api, filmId = movieId, filmType)
            }
        ).flow
    }

    fun getRecommendedFilms(movieId: Int, filmType: FilmType): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                RecommendedFilmSource(api = api, filmId = movieId, filmType)
            }
        ).flow
    }

    /** Non-paging data */
    suspend fun getFilmCast(filmId: Int, filmType: FilmType): Resource<CastResponse> {
        val response = try {
            if (filmType == FilmType.MOVIE) api.getMovieCast(filmId = filmId)
            else api.getTvShowCast(filmId = filmId)
        } catch (e: Exception) {
            return Resource.Error("Error when loading movie cast")
        }
        return Resource.Success(response)
    }
}
