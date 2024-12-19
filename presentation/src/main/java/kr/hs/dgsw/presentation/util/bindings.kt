package kr.hs.dgsw.presentation.util

import android.app.Activity
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

inline fun <reified VB: ViewBinding> Fragment.bindings(
    crossinline inflate: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy {
        inflate.invoke(layoutInflater)
    }
}

inline fun <reified VB: ViewBinding> Activity.bindings(
    crossinline inflate: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy {
        inflate.invoke(layoutInflater)
    }
}