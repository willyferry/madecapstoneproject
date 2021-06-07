package com.example.madecapstoneproject.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.data.Resource
import com.example.core.ui.GameAdapter
import com.example.madecapstoneproject.R
import com.example.madecapstoneproject.databinding.ActivityHomeBinding
import com.example.madecapstoneproject.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeGameViewModel: HomeGameViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameAdapter = GameAdapter()
        gameAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        homeGameViewModel.games.observe(this, { games ->
            if (games != null) {
                when (games) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        games.data?.let { gameAdapter.setData(it) }
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Sorry, Something is error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with (binding.rvGame) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = gameAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            val uri = Uri.parse("gamesapp://favorite")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}