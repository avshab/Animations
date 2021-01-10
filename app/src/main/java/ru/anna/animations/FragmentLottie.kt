package ru.anna.animations

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

/**
 * Created by Anna Shabaeva on 1/10/21
 */
class FragmentLottie : Fragment(R.layout.lottie_fragment) {

    private val lottieView: LottieAnimationView
        get() = requireView().findViewById(R.id.lottieView)

    private val nextButton: AppCompatButton
        get() = requireView().findViewById(R.id.nextButton)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            animateNextLottie()
        }

    }

    private val animations = listOf(
        "13267-circular-loader-success.json",
        "43792-yoga-se-hi-hoga.json"
    )

    private var nextStep = 0

    private fun animateNextLottie() {
        nextStep ++
        nextStep %= animations.size
        val animation = animations[nextStep]

        lottieView.setAnimation(animation)
        lottieView.repeatCount = LottieDrawable.INFINITE
        lottieView.playAnimation()
    }

}