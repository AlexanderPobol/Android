package com.pobol.home5

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import com.pobol.home.R

class BottomSheetNavigationFragment : BottomSheetDialogFragment() {
    private val mBottomSheetBehaviorCallback: BottomSheetCallback = object : BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            if (slideOffset > 0.5) {
                closeButton!!.visibility = View.VISIBLE
            } else {
                closeButton!!.visibility = View.GONE
            }
        }
    }
    private var closeButton: ImageView? = null

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.menu_header, null)
        dialog.setContentView(contentView)
        val navigationView: NavigationView = contentView.findViewById(R.id.nv_navigation_view)

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav01 -> {
                }
            }
            false
        }
        closeButton = contentView.findViewById(R.id.img_close_image_view)
        closeButton?.setOnClickListener(View.OnClickListener { //dismiss bottom sheet
            dismiss()
        })
        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior
        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
    }

    companion object {
        fun newInstance(): BottomSheetNavigationFragment {
            val args = Bundle()
            val fragment = BottomSheetNavigationFragment()
            fragment.arguments = args
            return fragment
        }
    }
}