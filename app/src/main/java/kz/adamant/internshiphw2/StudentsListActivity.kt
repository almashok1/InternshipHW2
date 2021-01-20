package kz.adamant.internshiphw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kz.adamant.internshiphw2.databinding.ActivityMainBinding
import kz.adamant.internshiphw2.databinding.ActivityStudentsListBinding

class StudentsListActivity : AppCompatActivity() {
    private var _binding: ActivityStudentsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityStudentsListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val studentsList = StudentsListConstant.studentList.toList()
        Log.d("asd", studentsList.toString())
        adapter = StudentsAdapter()

        binding.rvStudents.adapter = adapter
        binding.rvStudents.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setList(studentsList)
    }
}