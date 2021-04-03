package com.pobol.home5

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pobol.home.R
import java.util.*

internal class PhotoSliderAdapter(var photoSliderItems: ArrayList<PhotoSliderItem>, var context: Context) :
        RecyclerView.Adapter<PhotoSliderAdapter.PhotoSliderViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PhotoSliderViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.photo_slider_item, viewGroup, false)
        return PhotoSliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PhotoSliderViewHolder, i: Int) {
        val photoItem = photoSliderItems[i]
        viewHolder.ImgPhotoSlide.setImageResource(photoItem.imageResource)
    }

    override fun getItemCount(): Int {
        return photoSliderItems.size
    }

    internal inner class PhotoSliderViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var ImgPhotoSlide: ImageView

        override fun onClick(v: View) {
            val position = adapterPosition
            val photoSliderItem = photoSliderItems[position]
            val intent = Intent(context, PhotoClickActivity::class.java)
            intent.putExtra("imageResource", photoSliderItem.imageResource)
            context.startActivity(intent)
        }

        init {
            itemView.setOnClickListener(this)
            ImgPhotoSlide = itemView.findViewById(R.id.img_photo_slide)
        }
    }
}