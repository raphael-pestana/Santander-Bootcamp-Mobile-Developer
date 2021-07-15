package com.pestana.mytodolist.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.pestana.mytodolist.databinding.ActivityAddTaskBinding
import com.pestana.mytodolist.extensions.format
import com.pestana.mytodolist.extensions.text
import java.util.*

class AddTaksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListerner ()
    }

    private fun insertListerner() {
        binding.tilDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offSet = timeZone.getOffset(Date().time) * -1
                binding.tilDate.text = Date(it + offSet).format()

            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }
}