/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 23:20
 */

package cl.figonzal.evaluatool.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.FirebaseDialogLayoutBinding
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase


class FirebaseDialogFragment(
    private val sharedPreferences: SharedPrefUtil,
    val activity: Activity
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = MaterialAlertDialogBuilder(requireContext())

        val binding = FirebaseDialogLayoutBinding.inflate(LayoutInflater.from(requireContext()))

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
            val spanText = SpannableString("Política de privacidad")

            val clickable = object : ClickableSpan() {
                override fun onClick(view: View) {
                }
            }

            spanText.setSpan(clickable, 0, spanText.length, 0)
            tvPrivacyPolicy.setText(spanText, TextView.BufferType.SPANNABLE)

            tvPrivacyPolicy.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("https://github.com/figonzal1/EvaluaTool/blob/main/privacy_policy.md")
                startActivity(intent)
            }

            builder.setView(root)
        }

        return builder.create()
    }
}