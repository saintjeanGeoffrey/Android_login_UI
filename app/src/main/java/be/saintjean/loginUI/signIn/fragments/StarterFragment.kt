package be.saintjean.loginUI.signIn.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation.findNavController

import be.saintjean.loginUI.R


class StarterFragment : Fragment() {

    private lateinit var mBtn_signUp: Button
    private lateinit var mBtn_goToSignUp: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_starter, container, false)
        init(v)
        listerners()
        return v
    }

    private fun listerners() {
        mBtn_signUp.setOnClickListener {
            findNavController(it).navigate(R.id.action_starter_to_signIn)
        }

        mBtn_goToSignUp.setOnClickListener {
            findNavController(it).navigate(R.id.action_starter_to_signUp)
        }
    }

    private fun init(v: View) {
        mBtn_signUp = v.findViewById(R.id.btn_signUp)
        mBtn_goToSignUp = v.findViewById(R.id.btn_goToSignUp)
    }


}
