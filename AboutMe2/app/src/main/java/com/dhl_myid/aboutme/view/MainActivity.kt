package com.dhl_myid.aboutme.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dhl_myid.aboutme.R
import com.dhl_myid.aboutme.databinding.ActivityMainBinding
import com.dhl_myid.aboutme.model.Name

class MainActivity : AppCompatActivity() {

    //Late inits
    private lateinit var binding: ActivityMainBinding

    //Variables
    private val name: Name = Name("Joey Sparidaans")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.name = name
        binding.doneButton.setOnClickListener { addNickname(it) }
        binding.nicknameText.setOnClickListener { updateNickname() }
    }

    private fun addNickname(view: View) {
        val inputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.apply {
            name?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.text = name?.nickname
            nicknameText.visibility = View.VISIBLE
            invalidateAll()
        }
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE

            nicknameEdit.requestFocus()
            inputMethodManager.showSoftInput(nicknameEdit, 0)
        }

    }
}