package com.kingwolf.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        // Xử lý sự kiện khi nhấn vào Button
        val buttonReplace = view.findViewById<Button>(R.id.button_replace)
        buttonReplace.setOnClickListener {
            replaceFragmentB()
        }

        return view
    }

    private fun replaceFragmentB() {
        val fragmentB = FragmentB()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentB)
            .commit()
    }
}