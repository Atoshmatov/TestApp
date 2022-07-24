package uz.gita.testapp.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(@ApplicationContext context: Context) {
    private val pref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

    //language position
    var language: String
        get() = pref.getString("lang", "")!!
        set(value) = pref.edit().putString("lang", value).apply()

    var theme: Boolean
        get() = pref.getBoolean("theme", false)
        set(value) = pref.edit().putBoolean("theme", value).apply()
}