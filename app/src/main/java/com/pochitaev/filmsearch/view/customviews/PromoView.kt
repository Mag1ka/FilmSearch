package com.pochitaev.filmsearch.view.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pochitaev.filmsearch.databinding.MergePromoBinding
import com.pochitaev.filmsearch.di.AppComponent
import com.pochitaev.remote_module.entity.ApiConstants

class PromoView(context: Context, attributeSet: AttributeSet?) : FrameLayout(context, attributeSet) {
    lateinit var dagger: AppComponent
    val binding = MergePromoBinding.inflate(LayoutInflater.from(context), this)
    val watchButton = binding.watchButton

    fun setLinkForPoster(link: String) {
        Glide.with(binding.root)
            .load(ApiConstants.IMAGES_URL  + "w500" + link)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(55)))
            .into(binding.poster)
    }
}