package kz.adamant.internshiphw2

import java.util.*

data class Student(val firstName: String, val lastName: String) : Comparable<Student>{
    override operator fun compareTo(student: Student): Int {
        val fullName1 = (firstName + lastName).toLowerCase(Locale.ROOT)
        val fullName2 = (student.firstName+student.lastName).toLowerCase(Locale.ROOT)
        return fullName1.compareTo(fullName2)
    }
}