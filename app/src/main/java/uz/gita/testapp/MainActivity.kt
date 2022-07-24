package uz.gita.testapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.testapp.data.SharedPref
import uz.gita.testapp.utils.LocaleHelper
import uz.gita.testapp.utils.Theme
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var shared: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = SharedPref(this)
        if (shared!!.theme)
            Theme.goInDarkMode()
        Slidr.attach(this)
    }

    override fun attachBaseContext(newBase: Context?) {
        val local = Locale(SharedPref(newBase ?: this).language)
        val contextWrapper = LocaleHelper.setLocale(newBase ?: this, local.toString())
        super.attachBaseContext(contextWrapper)
    }
}