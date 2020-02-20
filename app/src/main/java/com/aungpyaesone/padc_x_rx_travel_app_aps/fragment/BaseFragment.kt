package com.aungpyaesone.padc_x_rx_travel_app_aps.fragment

import androidx.fragment.app.Fragment
import com.aungpyaesone.padc_x_rx_travel_app_aps.view.viepods.EmptyViewPod
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {
    protected lateinit var viewPortEmpty: EmptyViewPod
    protected fun showSnackbar(message:String){
        activity?.window?.decorView?.let { Snackbar.make(it,message,Snackbar.LENGTH_SHORT).show() }
    }
}