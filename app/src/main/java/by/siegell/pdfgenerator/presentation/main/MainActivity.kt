package by.siegell.pdfgenerator.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import by.siegell.pdfgenerator.databinding.ActivityMainBinding
import by.siegell.pdfgenerator.domain.entity.DocumentTypeData
import by.siegell.pdfgenerator.domain.entity.Type
import by.siegell.pdfgenerator.presentation.LoanAgreementData
import by.siegell.pdfgenerator.presentation.detail.DetailActivity
import by.siegell.pdfgenerator.presentation.main.rv.DocumentTypeAdapter

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DocumentTypeAdapter()
        adapter.onClick = { docType ->
            resolveDocumentType(docType)
        }
        binding.recycler.adapter = adapter

        viewModel.documentList.observe(this) {
            adapter.submitList(it)
        }
        viewModel.loadDocumentList()
    }

    private fun resolveDocumentType(documentTypeData: DocumentTypeData) {
        // TODO нарушение Принципа подстановки Лисков
        when (documentTypeData.type) {
            Type.LOAN_AGREEMENT -> openDetailActivity(documentTypeData as LoanAgreementData)
        }
    }

    private fun openDetailActivity(loanAgreementData: LoanAgreementData) {
        startActivity(
            DetailActivity.createIntent(this, loanAgreementData)
        )
    }
}