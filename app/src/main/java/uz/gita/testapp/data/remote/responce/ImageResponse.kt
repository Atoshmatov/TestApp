package uz.gita.testapp.data.remote.responce

import java.io.Serializable

data class ImageResponse(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
):Serializable
