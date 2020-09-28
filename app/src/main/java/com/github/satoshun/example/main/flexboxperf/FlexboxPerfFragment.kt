package com.github.satoshun.example.main.flexboxperf

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.FlexboxPerfFragBinding
import com.google.android.material.chip.Chip

class FlexboxPerfFragment : Fragment(R.layout.flexbox_perf_frag) {
  private lateinit var binding: FlexboxPerfFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FlexboxPerfFragBinding.bind(view)

    repeat(50) {
      binding.flexbox1.addView(Chip(context).apply { text = "CHIP $it" })
    }

    repeat(50) {
      binding.flexbox2.addView(Chip(context).apply { text = "CHIP $it" })
    }
    repeat(50) {
      binding.flexbox3.addView(Chip(context).apply { text = "CHIP $it" })
    }

    repeat(50) {
      binding.flexbox4.addView(Chip(context).apply { text = "CHIP $it" })
    }
  }
}
