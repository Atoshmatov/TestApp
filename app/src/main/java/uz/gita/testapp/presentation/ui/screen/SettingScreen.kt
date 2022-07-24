package uz.gita.testapp.presentation.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.testapp.MainActivity
import uz.gita.testapp.R
import uz.gita.testapp.data.SharedPref
import uz.gita.testapp.databinding.ScreenSettingBinding
import uz.gita.testapp.presentation.ui.dialog.LangDialog
import uz.gita.testapp.presentation.ui.dialog.ThemeDialog
import uz.gita.testapp.presentation.viewModel.SettingVIewModel
import uz.gita.testapp.presentation.viewModel.impl.SettingVIewModelImpl
import uz.gita.testapp.utils.LocaleHelper
import uz.gita.testapp.utils.Theme.goInDarkMode
import uz.gita.testapp.utils.Theme.goInLightMode

@AndroidEntryPoint
class SettingScreen : Fragment(R.layout.screen_setting) {
    private val binding by viewBinding(ScreenSettingBinding::bind)
    private val viewModel: SettingVIewModel by viewModels<SettingVIewModelImpl>()
    private var shared: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openDialogLiveData.observe(this@SettingScreen, openDialogObserver)
        viewModel.openDialogThemeLiveData.observe(this@SettingScreen, openDialogThemeObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPref(requireContext())
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            viewModel.back()
        }
        language.setOnClickListener {
            viewModel.openDialog()
        }
        theme.setOnClickListener {
            viewModel.openThemeDialog()
        }
        viewModel.backLiveData.observe(viewLifecycleOwner, backObserver)
    }


    private val backObserver = Observer<Unit> {
        findNavController().popBackStack()
    }

    private val openDialogObserver = Observer<Unit> {
        val dialog = LangDialog()
        dialog.setonClickEngListener {
            LocaleHelper.setLocale(requireContext(), it)
            shared!!.language = it
            setText()
        }
        dialog.setonClickUzbListener {
            LocaleHelper.setLocale(requireContext(), it)
            shared!!.language = it
            setText()
        }
        dialog.setonClickRuListener {
            LocaleHelper.setLocale(requireContext(), it)
            binding.settingText.setText(R.string.setting)
            shared!!.language = it
            setText()
        }
        dialog.show(childFragmentManager, "")
    }
    private val openDialogThemeObserver = Observer<Unit> {
        val dialog = ThemeDialog()
        dialog.setonClickDarkListener {
            goInDarkMode()
            reset()
            shared!!.theme = true
        }
        dialog.setonClickLightListener {
            goInLightMode()
            reset()
            shared!!.theme = false
        }
        dialog.show(childFragmentManager, "")
    }

    private fun setText() {
        binding.settingText.setText(R.string.setting)
        binding.languageText.setText(R.string.program_language)
        binding.themeText.setText(R.string.theme)
    }

    private fun reset() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}