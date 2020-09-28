package com.github.satoshun.example.main.maxheight

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.FlexboxMaxHeightFragBinding
import com.google.android.material.chip.Chip

class FlexboxMaxHeightFragment : Fragment(R.layout.flexbox_max_height_frag) {
  private lateinit var binding: FlexboxMaxHeightFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FlexboxMaxHeightFragBinding.bind(view)

    repeat(50) {
      binding.flexbox1.addView(Chip(context).apply { text = "CHIP $it" })
    }

    val ids = IntArray(100)
    repeat(50) {
      val chip = Chip(context).apply { text = "CHIP $it" }
      val id = View.generateViewId()
      chip.id = id
      binding.container2.addView(chip)
      ids[it] = id
    }
    binding.flow.referencedIds = ids
  }
}