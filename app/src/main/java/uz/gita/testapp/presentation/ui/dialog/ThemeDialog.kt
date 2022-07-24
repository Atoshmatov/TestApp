package uz.gita.testapp.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.testapp.R
import uz.gita.testapp.databinding.LanguageItemBinding
import uz.gita.testapp.databinding.ThemeItemBinding

@AndroidEntryPoint
class ThemeDialog : DialogFragment(R.layout.theme_item) {

    private val binding by viewBinding(ThemeItemBinding::bind)
    private var onClickDarkListener: ((String) -> Unit)? = null
    private var onClickLightListener: ((String) -> Unit)? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogTheme_transparent)
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme_transparent
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
//        view.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dark.setOnClickListener {
            onClickDarkListener?.invoke("eng")
            dismiss()
        }
        light.setOnClickListener {
            onClickLightListener?.invoke("uz")
            dismiss()
        }
    }

    fun setonClickDarkListener(block: (String) -> Unit) {
        onClickDarkListener = block
    }

    fun setonClickLightListener(block: (String) -> Unit) {
        onClickLightListener = block
    }
}