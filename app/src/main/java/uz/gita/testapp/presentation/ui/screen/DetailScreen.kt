package uz.gita.testapp.presentation.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.testapp.R
import uz.gita.testapp.databinding.ScreenDetailBinding
import uz.gita.testapp.presentation.viewModel.DetailViewModel
import uz.gita.testapp.presentation.viewModel.impl.DetailViewModelImpl

@AndroidEntryPoint
class DetailScreen : Fragment(R.layout.screen_detail) {
    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModels<DetailViewModelImpl>()
    private val args: DetailScreenArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(imageDetail)
            .load(args.image.download_url)
            .placeholder(R.drawable.download)
            .into(imageDetail)
        backScreen.setOnClickListener {
            viewModel.back()
        }
        imageText.text = args.image.author
        viewModel.backLiveData.observe(viewLifecycleOwner, backObserver)
    }

    private val backObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}