package com.technical.test.macropay.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.technical.test.macropay.R
import com.technical.test.macropay.databinding.FragmentRegisterBinding
import com.technical.test.macropay.ui.base.BaseFragment
import com.technical.test.macropay.ui.home.HomeActivity

class RegisterFragment : BaseFragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() = with(binding) {
        loginButton.setOnClickListener {
            signIn(
                email = emailEdit.text.toString(),
                pwd = passwordEdit.text.toString()
            )
        }
    }

    private fun signIn(email: String, pwd: String) = with(binding){
        pbLoading.visibility = View.VISIBLE
        getFirebaseAuth().createUserWithEmailAndPassword(email, pwd)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Log.d("TESTER", "createUserWithEmail:success")
                    pbLoading.visibility = View.GONE
                    startActivity(Intent(requireActivity(), HomeActivity::class.java))
                    requireActivity().finish()
                } else {
                    Log.w("TESTER", "createUserWithEmail:failure", task.exception!!.cause)
                    pbLoading.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

}