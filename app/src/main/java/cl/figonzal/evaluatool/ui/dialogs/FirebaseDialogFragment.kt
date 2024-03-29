/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 21:25
 */

package cl.figonzal.evaluatool.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.FirebaseDialogLayoutBinding
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

/**
 * Class that handle privacy_policy dialog fragment
 *
 * @property sharedPreferences Preferences uses to load keys/values for dialog
 * @property activity Used to finish activity
 */
class FirebaseDialogFragment(
    private val sharedPreferences: SharedPrefUtil,
    val activity: Activity
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = MaterialAlertDialogBuilder(requireContext())

        val binding = FirebaseDialogLayoutBinding.inflate(layoutInflater)

        this.isCancelable = false

        with(binding) {


            btnAceptar.setOnClickListener {
                sharedPreferences.saveData(getString(R.string.SHARED_PREF_PRIVACY_POLICY), true)
                Firebase.crashlytics.setCustomKey(
                    getString(R.string.SHARED_PREF_PRIVACY_POLICY),
                    true
                )
                dismiss()
            }

            btnCancelar.setOnClickListener {
                sharedPreferences.saveData(getString(R.string.SHARED_PREF_PRIVACY_POLICY), false)
                Firebase.crashlytics.setCustomKey(
                    getString(R.string.SHARED_PREF_PRIVACY_POLICY),
                    false
                )
                activity.finish()
            }
            val spanText = SpannableString(getString(R.string.politica_privacidad))

            val clickable = object : ClickableSpan() {
                override fun onClick(view: View) {
                    //Not used
                }
            }

            spanText.setSpan(clickable, 0, spanText.length, 0)
            tvPrivacyPolicy.setText(spanText, TextView.BufferType.SPANNABLE)

            tvPrivacyPolicy.setOnClickListener {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(getString(R.string.PRIVACY_POLICY_URL))
                    startActivity(this)
                }

            }

            builder.setView(root)
        }

        return builder.create()
    }
}