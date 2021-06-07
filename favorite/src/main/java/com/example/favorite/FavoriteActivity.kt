package com.example.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.ui.GameAdapter
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.madecapstoneproject.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private val favoriteGameViewModel: FavoriteGameViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Favorite Games"

        val gameAdapter = GameAdapter()
        gameAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteGameViewModel.favoriteGames.observe(this, { favoriteGames ->
            gameAdapter.setData(favoriteGames)
        })

        with (binding.rvFavorite) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = gameAdapter
        }
    }
}