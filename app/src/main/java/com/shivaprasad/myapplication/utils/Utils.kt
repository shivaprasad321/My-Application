package com.shivaprasad.task.utils

import android.os.Build
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Utils {

    companion object {
    fun date(): String{
        var formatted : String

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           val current =    LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
             formatted = current.format(formatter)
        } else {
           val sdf = SimpleDateFormat("yyyy-MM-dd")
           val currentDate = sdf.format(Date())
           formatted = currentDate.toString()
        }
        return formatted
    }

    fun chageDateFormat(date: String): String{

        val formattedDate:String

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val inputFormatter =   DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'",
                    Locale.ENGLISH
                )

                val outputFormatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
                val date: LocalDate = LocalDate.parse(date, inputFormatter)
                 formattedDate = outputFormatter.format(date)
            } else {
                val inputFormat =
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                val outputFormat = SimpleDateFormat("yyyy-MM-dd")
                val date = inputFormat.parse(date)
                 formattedDate = outputFormat.format(date)
            }

        return formattedDate
    }}
}