package com.andreasgift.ikigai

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.andreasgift.ikigai.databinding.ActivityMainBinding
import com.google.android.material.sidesheet.SideSheetBehavior
import com.google.android.material.sidesheet.SideSheetCallback
import com.google.android.material.sidesheet.SideSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowSidesheet.setOnClickListener {
            showSideSheet()
        }
    }

    private fun showSideSheet() {
        val sideSheetDialog = SideSheetDialog(this)

        sideSheetDialog.behavior.addCallback(object : SideSheetCallback() {
            override fun onStateChanged(sheet: View, newState: Int) {
                if (newState == SideSheetBehavior.STATE_DRAGGING) {
                    sideSheetDialog.behavior.state = SideSheetBehavior.STATE_EXPANDED
                }
            }

            override fun onSlide(sheet: View, slideOffset: Float) {}
        })

        val inflater = layoutInflater.inflate(R.layout.sidesheet, null)
        val btnClose = inflater.findViewById<ImageButton>(R.id.btn_close)

        btnClose.setOnClickListener {
            sideSheetDialog.dismiss()
        }

        sideSheetDialog.setCancelable(false)
        sideSheetDialog.setCanceledOnTouchOutside(true)
        sideSheetDialog.setContentView(inflater)
        sideSheetDialog.show()
    }
}