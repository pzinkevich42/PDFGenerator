package by.siegell.pdfgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.siegell.pdfgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val testDataFactory = TestDataFactory()

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

        adapter.submitList(testDataFactory.getTestDocumentTypes())
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