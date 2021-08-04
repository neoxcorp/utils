package com.github.neoxcorp.utils.keyboard.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.github.neoxcorp.utils.keyboard.KeyboardVisibilityEvent

fun Activity?.keyboardListener(owner: LifecycleOwner, isOpenKeyboard: (Boolean) -> Unit) {
    this?.let { activity ->
        KeyboardVisibilityEvent.setEventListener(activity, owner, { isOpenKeyboard.invoke(it) })
    }
}

fun FragmentActivity?.keyboardListener(isOpenKeyboard: (Boolean) -> Unit) {
    this?.let { activity ->
        KeyboardVisibilityEvent.setEventListener(activity, activity, { isOpenKeyboard.invoke(it) })
    }
}

fun Fragment?.keyboardListener(isOpenKeyboard: (Boolean) -> Unit) {
    this?.activity?.let { activity ->
        KeyboardVisibilityEvent.setEventListener(activity, this, { isOpenKeyboard.invoke(it) })
    }
}