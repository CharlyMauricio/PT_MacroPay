package com.technical.test.macropay.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.technical.test.macropay.databinding.ActivityHomeBinding
import com.technical.test.macropay.ui.auth.AuthenticationActivity
import com.technical.test.macropay.ui.base.BaseActivity
import com.technical.test.macropay.ui.home.detail.DetailActivity
import com.technical.test.macropay.utils.Constants.MOVIE

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    private val adapter = HomeMoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbLoading.visibility = View.VISIBLE

        val recycler = binding.rvMovies
        recycler.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(MOVIE, it)
            startActivity(intent)
        }

        recycler.adapter = adapter

        setListener()
        setObserver()
    }

    private fun setListener() = with(binding){
        ivLogout.setOnClickListener {
            Log.d("TESTER", "signOut:success")
            getFirebaseAuth().signOut()
            startActivity(Intent(this@HomeActivity, AuthenticationActivity::class.java))
        }

        onBackPressedDispatcher.addCallback {
            finish()
        }
    }

    private fun setObserver() = with(homeViewModel) {
        moviesList.observe(this@HomeActivity) { movieList ->
            Log.d("TESTER", " si paso, $movieList")
            binding.pbLoading.visibility = View.GONE
            adapter.submitList(movieList)
        }
    }
}