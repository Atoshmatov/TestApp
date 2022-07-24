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

@AndroidEntryPoint
class LangDialog : DialogFragment(R.layout.language_item) {

    private val binding by viewBinding(LanguageItemBinding::bind)
    private var onClickEngListener: ((String) -> Unit)? = null
    private var onClickUzbListener: ((String) -> Unit)? = null
    private var onClickRuListener: ((String) -> Unit)? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogTheme_transparent)
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme_transparent
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        view.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        eng.setOnClickListener {
            onClickEngListener?.invoke("eng")
            dismiss()
        }
        uzb.setOnClickListener {
            onClickUzbListener?.invoke("uz")
            dismiss()
        }
        ru.setOnClickListener {
            onClickRuListener?.invoke("ru")
            dismiss()
        }
    }

    fun setonClickEngListener(block: (String) -> Unit) {
        onClickEngListener = block
    }

    fun setonClickUzbListener(block: (String) -> Unit) {
        onClickUzbListener = block
    }

    fun setonClickRuListener(block: (String) -> Unit) {
        onClickRuListener = block
    }
}