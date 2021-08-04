package com.github.neoxcorp.utils.keyboard

fun interface KeyboardVisibilityEventListener {
    fun onKeyboardStateChanged(isOpenKeyboard: Boolean)
}
