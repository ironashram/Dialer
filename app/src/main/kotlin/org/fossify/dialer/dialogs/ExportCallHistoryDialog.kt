package org.fossify.dialer.dialogs

import androidx.appcompat.app.AlertDialog
import org.fossify.commons.extensions.*
import org.fossify.dialer.R
import org.fossify.dialer.activities.SimpleActivity
import org.fossify.dialer.databinding.DialogExportCallHistoryBinding

class ExportCallHistoryDialog(val activity: SimpleActivity, callback: (filename: String) -> Unit) {

    init {
        val binding = DialogExportCallHistoryBinding.inflate(activity.layoutInflater).apply {
            exportCallHistoryFilename.setText("call_history_${activity.getCurrentFormattedDateTime()}")
        }

        activity.getAlertDialogBuilder().setPositiveButton(org.fossify.commons.R.string.ok, null).setNegativeButton(
            org.fossify.commons.R.string.cancel, null).apply {
            activity.setupDialogStuff(binding.root, this, R.string.export_call_history) { alertDialog ->
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {

                    val filename = binding.exportCallHistoryFilename.value
                    when {
                        filename.isEmpty() -> activity.toast(org.fossify.commons.R.string.empty_name)
                        filename.isAValidFilename() -> {
                            callback(filename)
                            alertDialog.dismiss()
                        }

                        else -> activity.toast(org.fossify.commons.R.string.invalid_name)
                    }
                }
            }
        }
    }
}
