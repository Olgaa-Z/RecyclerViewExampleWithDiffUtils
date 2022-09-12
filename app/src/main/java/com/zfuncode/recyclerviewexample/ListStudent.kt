package com.zfuncode.recyclerviewexample

import java.io.Serializable

data class ListStudent(
    val nama : String,
    val nim : String,
    val img : Int,
    val alamat:String
) : Serializable
