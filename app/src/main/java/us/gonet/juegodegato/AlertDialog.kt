package us.gonet.juegodegato


import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog


class AlertDialog : DialogFragment() {
    fun onCreateDialog(savedInstanceState: Bundle): AlertDialog {
        val builder = AlertDialog.Builder(this.context!!)
        builder.setMessage(R.string.aceptar)
            .setPositiveButton(R.string.aceptar, DialogInterface.OnClickListener { dialog, id ->
                // FIRE ZE MISSILES!
            })
        return builder.create()
    }
}