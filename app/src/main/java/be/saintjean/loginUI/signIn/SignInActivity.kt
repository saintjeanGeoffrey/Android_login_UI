package be.saintjean.loginUI.signIn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import be.saintjean.loginUI.R
import be.saintjean.loginUI.signIn.fragments.SignInFragment


class SignInActivity : AppCompatActivity(), SignInFragment.CallbackFragment {

    private lateinit var navController: NavController
    private lateinit var  mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        init()

//        setSupportActionBar(findViewById(R.id.custom_toolbar))

//        supportActionBar?.setDisplayShowTitleEnabled(false)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    private fun init() {

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}
