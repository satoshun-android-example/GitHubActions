package com.github.satoshun.example.main.maxline

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.FlexboxMaxLineBinding
import com.google.android.material.chip.Chip
import jp.co.matchingagent.cocotsure.flexbox.FlexboxLayoutManager

class MaxLineFragment : Fragment(R.layout.flexbox_max_line) {
  private lateinit var binding: FlexboxMaxLineBinding

  @SuppressLint("SetTextI18n")
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FlexboxMaxLineBinding.bind(view)

    repeat(50) {
      binding.flexbox1.addView(Chip(context).apply { text = "CHIP $it" })
    }
    repeat(50) {
      binding.flexbox2.addView(
        Chip(context).apply {
          text = "CHIP $it"
          isCheckable = true
          setOnClickListener {
            it as Chip
            it.isChecked = true
          }
        }
      )
    }
    repeat(50) {
      binding.flexbox3.addView(
        Chip(context).apply {
          text = "CHIP $it"
        }
      )
    }

    binding.flexbox4.layoutManager = FlexboxLayoutManager(requireContext()).apply {
      maxLine = 2
    }
    binding.flexbox4.adapter = SampleAdapter().apply {
      submitList((0..50).map {
        Data("CHIP $it", false)
      })
    }
  }
}

class SampleAdapter : ListAdapter<Data, RecyclerView.ViewHolder>(
  object : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
      return oldItem.label == newItem.label
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
      return oldItem == newItem
    }
  }
) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val chip = Chip(parent.context)
    return object : RecyclerView.ViewHolder(chip) {}
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val chip = holder.itemView as Chip
    val data = getItem(position)
    chip.text = data.label
    chip.isChecked = data.isChecked
    chip.isCheckable = true

    chip.setOnClickListener {
      chip.isChecked = true
//      data.isChecked = !data.isChecked
//      val v = it.parent as RecyclerView
//      val m = v.layoutManager as FlexboxLayoutManager
//      submitList(currentList.toList())
    }
  }
}

data class Data(
  var label: String,
  var isChecked: Boolean
)
