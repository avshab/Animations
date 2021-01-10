package ru.anna.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private val animTabButton: AppCompatButton
        get() = findViewById(R.id.animTabButton)

    private val lottieTabButton: AppCompatButton
        get() = findViewById(R.id.lottieTabButton)

    private val defaultFragment: ConstraintLayout
        get() = findViewById(R.id.defaultFragment)

    private val lottieFragment: ConstraintLayout
        get() = findViewById(R.id.lottieFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchState(TabState.ANIMATION)

        animTabButton.setOnClickListener { switchState(TabState.ANIMATION) }
        lottieTabButton.setOnClickListener { switchState(TabState.LOTTIE) }
    }

    private fun switchState(state: TabState) {

        findViewById<View>(R.id.defaultFragment)
        when(state) {
            TabState.ANIMATION -> {
                lottieFragment.visibility = View.GONE
                defaultFragment.visibility = View.VISIBLE
            }
            TabState.LOTTIE -> {
                lottieFragment.visibility = View.VISIBLE
                defaultFragment.visibility = View.GONE
            }
        }
    }
}


enum class TabState {
    ANIMATION,
    LOTTIE
}