package com.pobol.home5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pobol.home.R
import java.util.*

class PhotoSliderFragment : Fragment(), View.OnClickListener {
    interface onSelectPhotoListener {
        fun onSelect(photoIndex: Int)
    }

    private var rvPhotoSlider: RecyclerView? = null
    private var rvAdapter: RecyclerView.Adapter<*>? = null
    private var rvLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.photo_slider_fragment, container, false)
        rvPhotoSlider = rootView.findViewById(R.id.rv_photo_slider)
        rvPhotoSlider?.setHasFixedSize(true)
        Log.d("myTag", "photosliderfragment ")
        val photoSliderItems: ArrayList<PhotoSliderItem> = ArrayList<PhotoSliderItem>()
        photoSliderItems.add(PhotoSliderItem(R.drawable.a1))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a2))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a3))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a4))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a5))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a6))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a7))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a8))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a9))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a10))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a11))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a12))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a13))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a14))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a15))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a16))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a17))
        photoSliderItems.add(PhotoSliderItem(R.drawable.a18))
        rvAdapter = PhotoSliderAdapter(photoSliderItems, rootView.context)
        rvLayoutManager = GridLayoutManager(rootView.context, 3)
        rvPhotoSlider?.setAdapter(rvAdapter)
        rvPhotoSlider?.setLayoutManager(rvLayoutManager)
        return rootView
    }

    override fun onClick(v: View) {}
}