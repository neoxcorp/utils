package com.github.neoxcorp.utils.keyboard.extensions

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View

fun View?.scaleUp(
    scaleTo: Float = 1F,
    scaleDuration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    this.scale(scaleTo, scaleDuration, start, end, cancel, repeat)
}

fun View?.scaleDown(
    scaleTo: Float = 0.1F,
    scaleDuration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    this.scale(scaleTo, scaleDuration, start, repeat, cancel, end)
}

fun View?.scale(
    scaleTo: Float = 1F,
    scaleDuration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    this?.let { view ->
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            view,
            PropertyValuesHolder.ofFloat("scaleX", scaleTo),
            PropertyValuesHolder.ofFloat("scaleY", scaleTo)
        )

        animator.duration = scaleDuration

        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                start.invoke()
            }

            override fun onAnimationEnd(animation: Animator?) {
                end.invoke()
            }

            override fun onAnimationCancel(animation: Animator?) {
                animator.removeAllListeners()
                cancel.invoke()
            }

            override fun onAnimationRepeat(animation: Animator?) {
                repeat.invoke()
            }
        })

        animator.start()
    }
}