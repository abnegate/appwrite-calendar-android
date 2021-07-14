package com.example.calwrite.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calwrite.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private val eventViewModel by viewModels<EventViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEventBinding.inflate(
            inflater,
            container,
            false
        )
        val root = binding.root

        val textView: TextView = binding.textDashboard
        eventViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }
}