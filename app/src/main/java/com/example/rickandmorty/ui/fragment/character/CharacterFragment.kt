package com.geeks.rickandmorty.ui.fragment.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.ui.fragment.character.CharacterViewModel
import com.example.rickandmorty.ui.fragment.character.OnClick
import com.geeks.rickandmorty.data.model.characters.Character
import com.geeks.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var charactersAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun setupObserve() {
        viewModel.getCharacters().observe(viewLifecycleOwner) {
            charactersAdapter.submitList(it)
        }
    }

    private fun initialize() {
        charactersAdapter = CharacterAdapter(this@CharacterFragment)
        binding.rvCharacter.adapter = charactersAdapter
    }

    override fun onClick(model: Character) {
        val action = CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(model.id)
        Log.e("TAG", "onClick: $model.id", )
        findNavController().navigate(action)
    }
}