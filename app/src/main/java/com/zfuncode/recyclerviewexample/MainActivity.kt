package com.zfuncode.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterStudentdiff : StudentAdapterDiffUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterStudentdiff = StudentAdapterDiffUtil()

        val listStudent = arrayListOf(
            ListStudent("Andika", "24616724", R.drawable.ic_launcher_foreground, "bandung"),
            ListStudent("Titi", "64634634", R.drawable.ic_launcher_foreground,"jakarta"),
            ListStudent("Dwika", "536436436", R.drawable.ic_launcher_foreground,"malang"),
            ListStudent("Rois", "454345435",  R.drawable.ic_launcher_foreground,"padang"),
            ListStudent("Wiwit", "3252664",  R.drawable.oke, "yogyakarta")
        )

        var adapterStudent = StudentAdapter(listStudent)

        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        val gv = GridLayoutManager(this, 2)
        rvStudent.layoutManager = lm
        rvStudent.adapter = adapterStudent

        adapterStudent.onClick = {
            var pindah = Intent(this, DetailStudentActivity::class.java)
            pindah.putExtra("detailStudent", it )
            startActivity(pindah)
        }

//        ini update recyclerview menggunakan  notifyDataSetChanged
        btnUpdatetanpadiff.setOnClickListener{
            listStudent[3] = ListStudent("Update Rois", "111111", R.drawable.oke, "padang")
            adapterStudent = StudentAdapter(listStudent)
            rvStudent.adapter = adapterStudent
            adapterStudent.notifyDataSetChanged()
        }

//        ini update menggunakan diff Util
        btnUpdateDiff.setOnClickListener{
//            val list : MutableList<ListStudent> = listStudent.toMutableList()
            listStudent[1] = ListStudent("Update Titi", "12345", R.drawable.oke, "padang")
            adapterStudentdiff = StudentAdapterDiffUtil()
            adapterStudentdiff.submitData(listStudent)
            rvStudent.adapter = adapterStudentdiff
        }








    }
}