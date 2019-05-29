package com.vovas.lazyv.client.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vovas.lazyv.client.MainActivity

import com.vovas.lazyv.client.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_settings.*
import okhttp3.*
import java.io.IOException

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            goToWeb(3)
        }
        button2.setOnClickListener {
            goToWeb(6)
        }
        button3.setOnClickListener {
            goToWeb(5)
        }
        button4.setOnClickListener {
            goToWeb(4)
        }
        button5.setOnClickListener {
            goToWeb(0)
        }

        button6.setOnClickListener {
            goToWeb(2)
        }
    }

    private fun goToWeb(code: Int) {
        val passcode = requireContext()
            .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
            .getString(R.string.passcode.toString(), R.string.default_passcode.toString())!!
        val ipAddress = requireContext()
            .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
            .getString(R.string.ip_address.toString(), R.string.default_ip.toString())!!
        val port = requireContext()
            .getSharedPreferences(R.string.server_pref.toString(), Context.MODE_PRIVATE)
            .getString(R.string.port.toString(), R.string.default_passcode.toString())!!
        Log.d(TAG,"HOME frag passcode = $passcode, $ipAddress, $port")
        var client = OkHttpClient()
        var formBody = FormBody
            .Builder()
            .add("code", code.toString())
            .add("passcode", passcode)
            .build()
        var url = "http:$ipAddress:$port/press"
        Log.d(TAG, "url = $url")
        var request = Request
            .Builder()
            .url(url)
            .post(formBody)
            .build()
        Log.d(TAG, "url is $url" )
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Wrong address", Toast.LENGTH_SHORT).show()
                }
                Log.d(TAG, "upali $e")
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body().toString()
                Log.d(TAG, "received json: $json")
            }
        })
    }

    companion object {
        const val TAG = "Home"
    }


}
