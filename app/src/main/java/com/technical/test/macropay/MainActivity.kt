package com.technical.test.macropay

import android.content.Intent
import android.os.Bundle
import com.technical.test.macropay.ui.auth.AuthenticationActivity
import com.technical.test.macropay.ui.base.BaseActivity
import com.technical.test.macropay.ui.home.HomeActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentUser = getCurrentUser()
        if (currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, AuthenticationActivity::class.java))
            finish()
        }
    }

}