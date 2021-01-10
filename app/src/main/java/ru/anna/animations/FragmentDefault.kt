package ru.anna.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

/**
 * Created by Anna Shabaeva on 1/10/21
 */
class FragmentDefault : Fragment(R.layout.default_fragment) {

    private val increase: AppCompatButton
        get() = requireView().findViewById(R.id.increaseButton)

    private val counter: AppCompatTextView
        get() = requireView().findViewById(R.id.counter)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        increase.setOnClickListener { animate() }
    }

//    private fun animate() {
//        counter
//            .animate()
//            .scaleX(10F)
//            .scaleY(10F)
//            .alpha(0F)
//            .setDuration(2000L)
//            .withEndAction {
//                counter.alpha = 1F
//                counter.scaleX = 1F
//                counter.scaleY = 1F
//            }
//            .start()
//    }

//    private fun animate() {
//        counter.alpha = 1F
//        counter.scaleX = 1F
//        counter.scaleY = 1F
//
//        val anim1 = ObjectAnimator
//            .ofFloat(counter, "scaleX", 10F)
//            .setDuration(2000L)
//            .start()
//    }

    private fun animate() {
        counter.alpha = 1F
        counter.scaleX = 1F
        counter.scaleY = 1F

        val set = AnimatorSet()

        val scaleXInc = ObjectAnimator
            .ofFloat(counter, "scaleX", 2F)

        val scaleXDec = ObjectAnimator
            .ofFloat(counter, "scaleX", 0.5F)

        val scaleYInc = ObjectAnimator
            .ofFloat(counter, "scaleY", 2F)

        val scaleYDec = ObjectAnimator
            .ofFloat(counter, "scaleY", 0.5F)

        set.playSequentially(
            AnimatorSet().apply { playTogether(scaleYInc, scaleXDec) },
            AnimatorSet().apply { playTogether(scaleYDec, scaleXInc) }
        )
        set.interpolator = FastOutSlowInInterpolator()


        set.duration = 400L
        set.start()

    }
}