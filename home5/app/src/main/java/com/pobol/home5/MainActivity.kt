package com.pobol.home5

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pobol.home.R
import com.pobol.home5.PhotoSliderFragment.onSelectPhotoListener

class MainActivity : AppCompatActivity(), View.OnClickListener, onSelectPhotoListener {
    private var bottomAppBar: BottomAppBar? = null
    private var imgAvatar: ImageView? = null
    private var tvNumPosts: TextView? = null
    private var tvNumFollowers: TextView? = null
    private var tvWeb: TextView? = null
    private var butFollow: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListener()
        tvWeb!!.movementMethod = LinkMovementMethod.getInstance()
        setUpBottomAppBar()
    }

    private fun setListener() {
        imgAvatar!!.setOnClickListener(this)
        butFollow!!.setOnClickListener(this)
    }

    private fun init() {
        tvWeb = findViewById<View>(R.id.tv_web) as TextView
        tvNumPosts = findViewById<View>(R.id.tv_num_posts) as TextView
        tvNumFollowers = findViewById<View>(R.id.tv_num_followers) as TextView
        imgAvatar = findViewById(R.id.img_avatar)
        butFollow = findViewById(R.id.but_follow)
    }

    private fun setUpBottomAppBar() {
        bottomAppBar = findViewById(R.id.bar)
        setSupportActionBar(bottomAppBar)
        bottomAppBar?.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_notification -> Toast.makeText(this@MainActivity, "Notification clicked.", Toast.LENGTH_SHORT).show()
            }
            false
        })
        bottomAppBar?.setNavigationOnClickListener(View.OnClickListener {
            val bottomSheetDialogFragment: BottomSheetDialogFragment = BottomSheetNavigationFragment.newInstance()
            bottomSheetDialogFragment.show(supportFragmentManager, "Bottom Sheet Dialog Fragment")
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_notification -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_avatar -> startActivity(Intent(this@MainActivity, InstaActivity::class.java))
            R.id.but_follow -> addPost()
        }
    }

    private fun addPost() {
        var num = Integer.valueOf(tvNumFollowers!!.text.toString())
        num++
        tvNumFollowers!!.text = num.toString()
    }

    override fun onSelect(photoIndex: Int) {
        val fragmentManager = supportFragmentManager
        val photoSliderFragment = fragmentManager.findFragmentById(R.id.fr_photo_slider) as PhotoSliderFragment?
    }
}