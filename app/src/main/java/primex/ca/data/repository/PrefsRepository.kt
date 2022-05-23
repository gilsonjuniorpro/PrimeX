package primex.ca.data.repository

import kotlinx.coroutines.flow.Flow
import primex.ca.data.preferences.UserPreferences
import javax.inject.Inject

class PrefsRepository @Inject constructor(
    private val userPreferences: UserPreferences
) {
    suspend fun updateIncludeAdult(includeAdult: Boolean){
        userPreferences.updateIncludeAdult(includeAdult)
    }
    fun readIncludeAdult(): Flow<Boolean?> = userPreferences.includeAdultFlow
}
