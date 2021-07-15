package com.pestana.mytodolist.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.pestana.mytodolist.databinding.ActivityAddTaskBinding
import com.pestana.mytodolist.datasource.TaskDataSource
import com.pestana.mytodolist.extensions.format
import com.pestana.mytodolist.extensions.text
import com.pestana.mytodolist.model.Task
import java.util.*
import javax.security.auth.login.LoginException

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
        binding.tilHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()
            timePicker.addOnPositiveButtonClickListener {
                val minute = if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour
                binding.tilHour.text = "${hour}:${minute}"
            }
            timePicker.show(supportFragmentManager, null)
        }
        binding.btnCancel.setOnClickListener {
            finish()
        }
        binding.btnNewTask.setOnClickListener {
            val task = Task(
                    title = binding.tilTitle.text,
                    description = binding.tilDescription.text,
                    date = binding.tilDate.text,
                    hour = binding.tilHour.text,
            )
            TaskDataSource.insertTask(task)
            Log.e("TAG", "insertListerner: " + TaskDataSource.getList())
        }
    }
}