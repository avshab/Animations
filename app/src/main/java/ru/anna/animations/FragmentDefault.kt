package ru.anna.animations

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

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

    private fun animate() {
        counter
            .animate()
            .scaleX(10F)
            .scaleY(10F)
            .alpha(0F)
            .setDuration(2000L)
            .withEndAction {
                counter.alpha = 1F
                counter.scaleX = 1F
                counter.scaleY = 1F
            }
            .start()
    }
}