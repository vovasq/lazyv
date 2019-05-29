package com.vovas.lazyv.client.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.vovas.lazyv.client.MainActivity

import com.vovas.lazyv.client.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectButton.setOnClickListener {
            updateConnectData()
        }
        passcode.text = Editable.Factory.getInstance().newEditable(
            requireContext()
                        .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
                        .getString(R.string.passcode.toString(), R.string.default_passcode.toString()))
        ipAdress.text = Editable.Factory.getInstance().newEditable(
            requireContext()
                .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
                .getString(R.string.ip_address.toString(), R.string.default_ip.toString()))

        port.text = Editable.Factory.getInstance().newEditable(
            requireContext()
                .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
                .getString(R.string.port.toString(), R.string.default_port.toString()))

    }

    private fun updateConnectData() {
        requireContext()
            .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
            .edit()
            .putString(R.string.passcode.toString(), passcode.text.toString())
            .putString(R.string.ip_address.toString(), ipAdress.text.toString())
            .putString(R.string.port.toString(), port.text.toString())
            .apply()
        Log.d(
            TAG, "date on clicking " + passcode.text.toString()
                    + " " + ipAdress.text.toString() + " " + port.text.toString()
        )
    }

    companion object {
        const val TAG = "Settings"
    }

}