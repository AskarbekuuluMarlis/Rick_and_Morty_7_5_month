package com.example.rickandmorty.ui.fragment.character

import com.example.rickandmorty.data.model.characters.Character


interface OnClick {
    fun onClick(model: Character)
}