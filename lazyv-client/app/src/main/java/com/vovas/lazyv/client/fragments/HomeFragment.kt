package com.vovas.lazyv.client.fragments


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
        var client = OkHttpClient()
        var formBody = FormBody
            .Builder()
            .add("code", code.toString())
            .add("passcode", "kek")
            .build()
        var request = Request
            .Builder()
            .url("http:10.1.1.36:8777/press")
            .post(formBody)
            .build()
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "upali $e")
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body().toString()
                Log.d(TAG, "received json: $json")
            }
        })
//        var response = call.execute()
    }

    companion object {
        const val TAG = "Home"
    }


}
