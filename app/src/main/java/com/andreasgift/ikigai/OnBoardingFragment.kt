package com.andreasgift.ikigai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.andreasgift.ikigai.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = OnBoardingFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingTitles = requireContext().resources.getStringArray(R.array.onboarding_titles)
        val onBoardingTexts = requireContext().resources.getStringArray(R.array.onboarding_texts)
        with(binding) {
            tvTitle.text = onBoardingTitles[position]
            tvContent.text = onBoardingTexts[position]
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}