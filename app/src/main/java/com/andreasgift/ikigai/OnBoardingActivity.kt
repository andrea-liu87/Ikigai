package com.andreasgift.ikigai

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.andreasgift.ikigai.databinding.ActivityOnboardingBinding

private const val NUM_PAGES = 3

class OnBoardingActivity : FragmentActivity() {
    private var onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateCircleMarker(binding, position)
        }
    }

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.vp2Pager.adapter = pagerAdapter
        binding.vp2Pager.registerOnPageChangeCallback(onBoardingPageChangeCallback)
    }

    override fun onDestroy() {
        binding.vp2Pager.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (binding.vp2Pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.vp2Pager.currentItem = binding.vp2Pager.currentItem - 1
        }
    }

    /**
     * Update slider circle view based on fragment position
     */
    private fun updateCircleMarker(binding: ActivityOnboardingBinding, position: Int) {
        when (position) {
            0 -> {
                binding.ivFirstCircle.setImageDrawable(getDrawable(R.drawable.comp_view_slider_blue))
                binding.ivSecondCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
                binding.ivThirdCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
            }
            1 -> {
                binding.ivSecondCircle.setImageDrawable(getDrawable(R.drawable.comp_view_slider_blue))
                binding.ivFirstCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
                binding.ivThirdCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
            }
            2 -> {
                binding.ivThirdCircle.setImageDrawable(getDrawable(R.drawable.comp_view_slider_blue))
                binding.ivSecondCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
                binding.ivFirstCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
            }
            3 -> {
                binding.ivThirdCircle.setImageDrawable(getDrawable(R.drawable.comp_view_slider_blue))
                binding.ivSecondCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
                binding.ivThirdCircle.setImageDrawable(getDrawable(R.drawable.comp_view_circle_gray))
            }
        }
    }

    /**
     * A simple pager adapter that represents 3 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment =
            OnBoardingFragment.getInstance(position)
    }
}