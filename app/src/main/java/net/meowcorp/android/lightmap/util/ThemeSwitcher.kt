package net.meowcorp.android.lightmap.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "lightmap-settings")


enum class LightMapMode {
    DARK,
    LIGHT,
    SYSTEM
}

@Composable
fun getCurrentTheme() {
    // get theme from datastore
    val THEME_DATA = stringPreferencesKey("theme")
    val theme: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[THEME_DATA] ?: LightMapMode.SYSTEM
    }
}