package com.zfuncode.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_student.*

class DetailStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        var getDataDetail = intent.getSerializableExtra("detailStudent") as ListStudent
        imgDetail.setImageResource(getDataDetail.img)
        txtNamaDetail.text = getDataDetail.nama
        txtNimDetail.text = getDataDetail.nim

    }


}