package com.example.gameofthrones.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gameofthrones.data.model.Character
import com.example.gameofthrones.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment(), OnCharacterClick {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        viewModel.charactersLiveData().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.errorTextView.visibility = View.GONE
                binding.charactersRecyclerView.adapter = CharacterAdapter(it, this)
            } else {
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.visibility = View.VISIBLE
            }
            binding.progressBar.visibility = View.GONE
        }

    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.charactersRecyclerView.layoutManager = layoutManager
    }

    override fun onClick(characterInfo: Character) {
        findNavController().navigate(
            CharacterListFragmentDirections.actionCharacterListFragmentToCharacterFragment(
                characterInfo
            )
        )
    }
}

interface OnCharacterClick {
    fun onClick(characterInfo: Character)
}