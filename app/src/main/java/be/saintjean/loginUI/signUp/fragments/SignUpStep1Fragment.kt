package be.saintjean.loginUI.signUp.fragments


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

import be.saintjean.loginUI.R
import de.hdodenhof.circleimageview.CircleImageView


class SignUpStep1Fragment : Fragment() {

    private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    private val IMAGE_PICK_CODE = 10

    private lateinit var mBtn_nextStep: Button
    private lateinit var mBtn_navigateUp: ImageView
    private lateinit var mProfile_picture: CircleImageView


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

        mProfile_picture.setOnClickListener {
            if (allPermissionsGranted()) {
                pickImageFromGallery()
            }
            else {
                ActivityCompat.requestPermissions(requireActivity(), REQUIRED_PERMISSIONS, 1)
            }
        }

    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(context!!, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if (allPermissionsGranted()) {
                pickImageFromGallery()
            } else {
                Toast.makeText(context,"Permissions not granted by the user.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun init(v: View) {
        mBtn_navigateUp = v.findViewById(R.id.btn_navigateUp)
        mBtn_nextStep = v.findViewById(R.id.btn_signup_nextStep)
        mProfile_picture = v.findViewById(R.id.profile_picture)

    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            data?.let {
                var file: Uri = data.data!!

                mProfile_picture.setImageURI(data.data)
                mProfile_picture.borderWidth = 4

            }
        }
    }
}
