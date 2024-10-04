package com.example.rickandmorty.ui.fragment.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.geeks.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.geeks.rickandmorty.ui.fragment.detail.CharacterDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {
    private lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListData()
    }

    private fun initListData() = with(binding) {
        Log.e("TAG", "initListData: ${args.id}")
        viewModel.getCharacter(args.id).observe(viewLifecycleOwner) { resource ->
            characterNameTextView.text = resource.name
            characterStatusTextView.text = resource.status
            characterGenderTextView.text = resource.gender
            lastKnownLocationTextView.text = resource.location.name
            headerImageView.load(resource.image)


        }
    }
}
