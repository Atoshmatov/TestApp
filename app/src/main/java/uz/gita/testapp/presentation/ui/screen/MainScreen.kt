package uz.gita.testapp.presentation.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.testapp.R
import uz.gita.testapp.data.remote.responce.ImageResponse
import uz.gita.testapp.databinding.ScreenMainBinding
import uz.gita.testapp.presentation.ui.adapter.ImageAdapter1
import uz.gita.testapp.presentation.ui.adapter.ImageAdapter2
import uz.gita.testapp.presentation.viewModel.MainViewModel
import uz.gita.testapp.presentation.viewModel.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val adapter1 = ImageAdapter1()
    private val adapter2 = ImageAdapter2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openSettingScreenLiveData.observe(this@MainScreen, openSettingScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        imageList1.adapter = adapter1
        imageList2.adapter = adapter2
        imageList1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        imageList2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.loadH()
        viewModel.loadV()
        settingsScreen.setOnClickListener {
            viewModel.openSettingScreen()
        }
        adapter2.setOnclickItemListener {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))
        }
        viewModel.cardListHLIveData.observe(viewLifecycleOwner, cardListHObserver)
        viewModel.cardListVLIveData.observe(viewLifecycleOwner, cardListVObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
    }

    private val cardListHObserver = Observer<List<ImageResponse>> {
        adapter1.submitList(it)
    }
    private val cardListVObserver = Observer<List<ImageResponse>> {
        adapter2.submitList(it)
    }
    private val progressObserver = Observer<Boolean> {
        if (it) {
            binding.signProgress1.show()
            binding.signProgress2.show()
        } else {
            binding.signProgress1.hide()
            binding.signProgress2.hide()
        }
    }

    private val openSettingScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_mainScreen_to_settingScreen)
    }
}