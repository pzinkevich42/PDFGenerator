package by.siegell.pdfgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import by.siegell.pdfgenerator.databinding.ActivityMainBinding

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