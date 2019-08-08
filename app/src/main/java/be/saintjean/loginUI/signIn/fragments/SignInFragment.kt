package be.saintjean.loginUI.signIn.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation

import be.saintjean.loginUI.R
import java.lang.RuntimeException


class SignInFragment : Fragment() {

    private var mCallbackFragment: CallbackFragment? = null

    private lateinit var mBtn_navigateUp: ImageView
    private lateinit var mBtn_goToSignUp: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val v = inflater.inflate(R.layout.fragment_sign_in, container, false)

        init(v)
        listeners()

        return v
    }

    private fun listeners() {
        mBtn_navigateUp.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        mBtn_goToSignUp.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signIn_to_signUp)
        }
    }


    private fun init(v: View) {
        mBtn_navigateUp = v.findViewById(R.id.btn_navigateUp)
        mBtn_goToSignUp = v.findViewById(R.id.btn_goToSignUp)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is CallbackFragment) {
            mCallbackFragment = context
        }
        else {
            throw RuntimeException(context.toString() + " must implement CallbackFragment")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mCallbackFragment = null
    }

    interface CallbackFragment {

    }

}
