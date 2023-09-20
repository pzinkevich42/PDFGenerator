package by.siegell.pdfgenerator.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import by.siegell.pdfgenerator.databinding.FragmentDocumentListBinding
import by.siegell.pdfgenerator.presentation.main.rv.DocumentTypeAdapter

class DocumentListFragment : Fragment() {

    private lateinit var binding: FragmentDocumentListBinding
    private val viewModel: DocumentListViewModel by viewModels()
    private val parentViewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDocumentListBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DocumentTypeAdapter()
        adapter.onClick = { docType ->
            parentViewModel.openDocument(docType)
        }
        binding.recycler.adapter = adapter

        viewModel.documentList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.loadDocumentList()
    }

    companion object {

        fun newInstance() = DocumentListFragment()
    }
}