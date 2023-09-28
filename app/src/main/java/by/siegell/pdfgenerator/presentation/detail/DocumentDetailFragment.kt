package by.siegell.pdfgenerator.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.siegell.pdfgenerator.databinding.FragmentDocumentDetailBinding
import by.siegell.pdfgenerator.presentation.LoanAgreementData

class DocumentDetailFragment : Fragment() {

    private lateinit var binding: FragmentDocumentDetailBinding
    private val viewModel: DocumentDetailViewModel by viewModels()

    private val args: DocumentDetailFragmentArgs by navArgs()
    private lateinit var data: LoanAgreementData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = args.documentData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDocumentDetailBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            dateRu.text = data.dateRu
            dateEn.text = data.dateEn
        }

        binding.generate.setOnClickListener {
            Toast.makeText(requireContext(), "Generate!", Toast.LENGTH_SHORT).show()
        }

    }
}