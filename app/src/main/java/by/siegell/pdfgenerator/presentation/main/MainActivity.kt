package by.siegell.pdfgenerator.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import by.siegell.pdfgenerator.databinding.ActivityMainBinding
import by.siegell.pdfgenerator.presentation.LoanAgreementData

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.openDocumentEvent.observe(this) {
            openDetailFragment(it)
        }
    }

    private fun openDetailFragment(loanAgreementData: LoanAgreementData) {

        binding
            .fragmentContainer
            .findNavController()
            .navigate(
                DocumentListFragmentDirections.actionDocumentListFragmentToDocumentDetailFragment(
                    loanAgreementData
                )
            )
    }
}