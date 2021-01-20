package kz.adamant.internshiphw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kz.adamant.internshiphw2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Update Count of Total Students
        setCountOfStudents()

        // logic to adding a student
        binding.btnAddStudent.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            if (firstName.isEmpty() || lastName.isEmpty()) {
                showToastMessage("A Field Cannot Be Empty!")
                return@setOnClickListener
            }
            val student = Student(firstName, lastName)

            if (!StudentsListConstant.studentList.contains(student)) {
                StudentsListConstant.studentList.add(student)
                setCountOfStudents()
                resetEditTexts()
                showToastMessage("Successfully Added!")
            } else {
                showToastMessage("A student has already defined")
            }
        }


        // Go to second Page
        binding.btnAllStudents.setOnClickListener {
            Intent(this, StudentsListActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun resetEditTexts() {
        binding.etFirstName.text = null
        binding.etLastName.text = null
    }

    private fun setCountOfStudents() {
        binding.tvCountTotalStudents.text = StudentsListConstant.studentList.size.toString()
    }


    private fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
            .show()
    }
}