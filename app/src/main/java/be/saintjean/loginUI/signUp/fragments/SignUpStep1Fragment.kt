package be.saintjean.loginUI.signUp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

import be.saintjean.loginUI.R


class SignUpStep1Fragment : Fragment() {

    private lateinit var mBtn_nextStep: Button
    private lateinit var mBtn_navigateUp: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val v: View = inflater.inflate(R.layout.fragment_sign_up_step1, container, false)
        init(v)
        listeners()
        return v
    }

    private fun listeners() {

        mBtn_navigateUp.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        mBtn_nextStep.setOnClickListener {
            findNavController(it).navigate(R.id.action_signUp1_to_signUp2)
        }

    }

    private fun init(v: View) {
        mBtn_navigateUp = v.findViewById(R.id.btn_navigateUp)
        mBtn_nextStep = v.findViewById(R.id.btn_signup_nextStep)
    }


}
