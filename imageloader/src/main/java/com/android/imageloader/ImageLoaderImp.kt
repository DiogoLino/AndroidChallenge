package com.android.imageloader

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ImageLoaderImp @Inject constructor(
    private val mGlide: RequestManager
) : ImageLoader {

    override fun load(
        url: String,
        imageView: ImageView,
        placeholder: Int
    ) {
        mGlide.load(url)
            .placeholder(placeholder)
            .into(imageView)
    }
}