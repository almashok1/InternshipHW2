package kz.adamant.internshiphw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.adamant.internshiphw2.databinding.ItemStudentBinding

class StudentsAdapter: RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {
    private var studentsList: List<Student> = mutableListOf()

    fun setList(studentsList: List<Student>) {
        this.studentsList = studentsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(studentsList[position])
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    class ViewHolder(private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvFirstName.text = student.firstName
            binding.tvLastName.text = student.lastName
            binding.tvInitial.text = "${student.firstName.first()}${student.lastName.first()}"
        }

        companion object {
            fun from(parent: ViewGroup): StudentsAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStudentBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}