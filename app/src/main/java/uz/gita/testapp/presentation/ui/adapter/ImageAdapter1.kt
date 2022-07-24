package uz.gita.testapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.testapp.R
import uz.gita.testapp.data.remote.responce.ImageResponse
import uz.gita.testapp.databinding.ImageItem2Binding

class ImageAdapter1 : ListAdapter<ImageResponse, ImageAdapter1.ViewHolder>(ImageCallBack) {
    private var onclickItemListener: ((ImageResponse) -> Unit)? = null

    object ImageCallBack : DiffUtil.ItemCallback<ImageResponse>() {
        override fun areItemsTheSame(oldItem: ImageResponse, newItem: ImageResponse): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ImageResponse, newItem: ImageResponse): Boolean =
            oldItem == newItem

    }

    inner class ViewHolder(private val binding: ImageItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onclickItemListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind(): ImageResponse = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                Glide
                    .with(image1)
                    .load(download_url)
                    .placeholder(R.drawable.map)
                    .into(image1)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ImageItem2Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnclickItemListener(block: (ImageResponse) -> Unit) {
        onclickItemListener = block
    }
}