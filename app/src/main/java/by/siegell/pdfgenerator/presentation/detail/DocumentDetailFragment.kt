package by.siegell.pdfgenerator.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.siegell.pdfgenerator.databinding.FragmentDocumentDetailBinding
import by.siegell.pdfgenerator.presentation.LoanAgreementData

class DocumentDetailFragment : Fragment() {

    private lateinit var binding: FragmentDocumentDetailBinding
    private val viewModel: DocumentDetailViewModel by viewModels()

    private lateinit var data: LoanAgreementData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = requireArguments().getSerializable(DOCUMENT_DATA_ARGUMENT) as LoanAgreementData
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

    companion object {

        const val TAG = "DocumentDetailFragment"
        private const val DOCUMENT_DATA_ARGUMENT = "DOCUMENT_DATA_ARGUMENT"

        fun newInstance(data: LoanAgreementData) = DocumentDetailFragment().apply {
            arguments = getBundle(data)
        }

        fun getBundle(data: LoanAgreementData) = Bundle().apply {
            putSerializable(DOCUMENT_DATA_ARGUMENT, data)
        }
    }
}