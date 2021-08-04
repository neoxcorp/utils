package com.github.neoxcorp.utils.keyboard

import android.app.Activity
import android.os.Build
import android.view.ViewTreeObserver

import java.lang.ref.WeakReference

class SimpleUnregister internal constructor(
    activity: Activity,
    globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
) : UnregisterListener {

    private val activityWeakReference: WeakReference<Activity> = WeakReference(activity)

    private val onGlobalLayoutListenerWeakReference: WeakReference<ViewTreeObserver.OnGlobalLayoutListener> =
        WeakReference(globalLayoutListener)

    override fun onUnregister() {
        val activity = activityWeakReference.get()
        val globalLayoutListener = onGlobalLayoutListenerWeakReference.get()

        if (null != activity && null != globalLayoutListener) {
            val activityRoot = KeyboardVisibilityEvent.getActivityRoot(activity)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activityRoot.viewTreeObserver
                    .removeOnGlobalLayoutListener(globalLayoutListener)
            } else {
                @Suppress("DEPRECATION")
                activityRoot.viewTreeObserver
                    .removeGlobalOnLayoutListener(globalLayoutListener)
            }
        }

        activityWeakReference.clear()
        onGlobalLayoutListenerWeakReference.clear()
    }
}
