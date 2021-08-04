package com.github.neoxcorp.utils.keyboard

import android.view.ViewTreeObserver

fun interface UnregisterListener {

    /**
     * unregisters the [ViewTreeObserver.OnGlobalLayoutListener] and there by does not provide any more callback to the [KeyboardVisibilityEventListener]
     */
    fun onUnregister()
}


