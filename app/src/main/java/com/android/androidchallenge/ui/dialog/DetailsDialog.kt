package com.android.androidchallenge.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class DetailsDialog : DialogFragment() {

    private lateinit var positiveButtonAction: () -> Unit
    private lateinit var heroName: String

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Your are About to Fire $heroName ")
                .setPositiveButton(
                    "Confirm"
                ) { _, _ ->
                    positiveButtonAction.invoke()
                }
                .setNegativeButton(
                    "Cancel"
                ) { _, _ ->
                    dismiss()
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        fun newInstance(
            name: String,
            positiveAction: () -> Unit
        ): DetailsDialog {
            return DetailsDialog().apply {
                positiveButtonAction = positiveAction
                heroName = name
            }
        }
    }
}