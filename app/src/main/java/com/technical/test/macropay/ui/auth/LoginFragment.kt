package com.technical.test.macropay.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.technical.test.macropay.R
import com.technical.test.macropay.databinding.FragmentLoginBinding
import com.technical.test.macropay.ui.base.BaseFragment
import com.technical.test.macropay.ui.home.HomeActivity

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() = with(binding) {
        loginButton.setOnClickListener {
            login(
                email = emailEdit.text.toString(),
                pwd = passwordEdit.text.toString()
            )
        }

        loginRegisterButton.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
    }

    private fun login(email: String, pwd: String) = with(binding) {
        pbLoading.visibility = VISIBLE
        getFirebaseAuth().signInWithEmailAndPassword(email, pwd)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Log.d("TESTER", "signInWithEmail:success ${getCurrentUser()}")
                    pbLoading.visibility = GONE
                    startActivity(Intent(requireActivity(), HomeActivity::class.java))
                    requireActivity().finish()
                } else {
                    Log.w("TESTER", "signInWithEmail:failure", task.exception)
                    pbLoading.visibility = GONE
                    Toast.makeText(
                        requireActivity(),
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
}