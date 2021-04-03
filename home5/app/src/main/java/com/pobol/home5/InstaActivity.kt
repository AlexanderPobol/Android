package com.pobol.home5

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pobol.home.R

class InstaActivity : AppCompatActivity(), View.OnClickListener {
    private var butBookMark: Button? = null
    private var butLike: Button? = null
    private var tvLike: TextView? = null
    private var tvBookmark: TextView? = null
    private var num: Int? = null
    private var num1: Int? = null
    private var bLike = false
    private var bBook = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myTag", "InstaActivity")
        setContentView(R.layout.insta_activity2)
        init()
        setListener()
    }

    private fun setListener() {
        butBookMark!!.setOnClickListener(this)
        butLike!!.setOnClickListener(this)
    }

    private fun init() {
        tvLike = findViewById<View>(R.id.tv_like) as TextView
        tvBookmark = findViewById<View>(R.id.tv_bookmark) as TextView
        butLike = findViewById(R.id.but_like)
        butBookMark = findViewById(R.id.but_bookmark)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.but_bookmark -> addBookmark()
            R.id.but_like -> addLike()
        }
    }

    private fun addBookmark() {
        num1 = Integer.valueOf(tvBookmark!!.text.toString())
        val i = num1
        if (bBook) {
            num1 = num1?.inc()

            tvBookmark!!.text = num1.toString()
            butBookMark!!.setBackgroundResource(R.drawable.ic_bookmark_on)
            bBook = false
        } else {
            num1 = num1?.dec()
            tvBookmark!!.text = num1.toString()
            butBookMark!!.setBackgroundResource(R.drawable.ic_bookmark_off)
            bBook = true
        }
    }

    private fun addLike() {
        num = Integer.valueOf(tvLike!!.text.toString())
        var i = num1
        if (bLike) {
            num = num?.inc()
            tvLike!!.text = num.toString()
            butLike!!.setBackgroundResource(R.drawable.ic_like)
            bLike = false
        } else {
            num = num?.dec()
            tvLike!!.text = num.toString()
            butLike!!.setBackgroundResource(R.drawable.ic_heart)
            bLike = true
        }
    }
}