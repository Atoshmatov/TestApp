package uz.gita.testapp.presentation.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.testapp.R
import uz.gita.testapp.databinding.ScrenSplashBinding
import uz.gita.testapp.presentation.viewModel.SplashViewModel
import uz.gita.testapp.presentation.viewModel.impl.SplashViewModelImpl

@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.scren_splash) {
    private val binding by viewBinding(ScrenSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openLanguageScreen.observe(this@SplashScreen, openLanguageObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
    }

    private val openLanguageObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_mainScreen)
    }
}