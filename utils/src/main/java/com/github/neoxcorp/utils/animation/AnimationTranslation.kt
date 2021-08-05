package com.github.neoxcorp.utils.animation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import kotlin.math.abs

fun View?.moveDown(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    val to = abs(translationTo)
    this.translationY(to, duration, start, cancel, repeat, end)
}

fun View?.moveUp(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    val to = - abs(translationTo)
    this.translationY(to, duration, start, cancel, repeat, end)
}

fun View?.moveRight(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    val to = abs(translationTo)
    this.translationX(to, duration, start, cancel, repeat, end)
}

fun View?.moveLeft(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    val to = - abs(translationTo)
    this.translationX(to, duration, start, cancel, repeat, end)
}

private fun View?.translationY(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    this?.let { view ->
        val animator = ObjectAnimator.ofFloat(view, "translationY", translationTo)

        animator.duration = duration

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

private fun View?.translationX(
    translationTo: Float = 100f,
    duration: Long = 300,
    start: () -> Unit = {},
    cancel: () -> Unit = {},
    repeat: () -> Unit = {},
    end: () -> Unit = {}
) {
    this?.let { view ->
        val animator = ObjectAnimator.ofFloat(view, "translationX", translationTo)

        animator.duration = duration

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