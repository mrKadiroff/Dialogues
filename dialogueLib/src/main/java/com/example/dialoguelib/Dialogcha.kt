package com.example.dialoguelib

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.*

object Dialogcha {

    fun AlertDialog(context: Context, title: String, message: String, posBtn: String, negBtn: String) {
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(negBtn) { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton(posBtn) { dialog, which ->
                // Respond to positive button press
            }
            .show()
    }


    fun checkbox(
        context: Context,
        title: String,
        posBtn: String,
        list: Array<String>,
        checked: Int
    ) {
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setPositiveButton(posBtn) { dialog, which ->
                // Respond to positive button press
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(list, checked) { dialog, which ->
                Toast.makeText(context, list[which], Toast.LENGTH_SHORT).show()
            }
            .show()
    }


    fun wifi(context: Context, layoutInflater: LayoutInflater, layout: Int) {
        var bottomsheet = BottomSheetDialog(context)
        val v = layoutInflater.inflate(layout, null)



        bottomsheet.setContentView(v)
        bottomsheet.show()
    }



    fun calendar(context: Context) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            // Display Selected date in textbox


        }, year, month, day)

        dpd.show()
    }








    @SuppressLint("CheckResult")
    fun color(context: Context, title: String,colorList:IntArray) {
        MaterialDialog(context).show {
            title(R.string.material_motion_easing_standard, title)
            colorChooser(colorList) { dialog, color ->
                Toast.makeText(context, color.toString(), Toast.LENGTH_SHORT).show()
            }
            negativeButton(null, "Cancel") {
                it.dismiss()
            }
            positiveButton(null, "Select")
        }
    }


}