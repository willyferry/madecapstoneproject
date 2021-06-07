package com.example.madecapstoneproject.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.core.domain.model.Game
import com.example.madecapstoneproject.R
import com.example.madecapstoneproject.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailGameViewModel: DetailGameViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        if(detailGame != null){
            showDetailGame(detailGame)
        }
    }

    private fun showDetailGame(detailGame: Game) {
        supportActionBar?.title = detailGame.name
        binding.tvName.text = detailGame.name
        binding.tvReleased.text = detailGame.released

        Glide.with(this)
            .load(detailGame.background_image)
            .into(binding.ivBackgroundImage)

        var statusFavorite = detailGame.isFavorite
        setStatusFavorite(statusFavorite)
        binding.btnFavorite.setOnClickListener {
            statusFavorite = !statusFavorite
            detailGameViewModel.setFavoriteGame(detailGame, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.btnFavorite.setText(R.string.remove_from_favorite)
            binding.btnFavorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_favorite_24, 0)
        } else {
            binding.btnFavorite.setText(R.string.add_to_favorite)
            binding.btnFavorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_favorite_border_24, 0)
        }
    }
}