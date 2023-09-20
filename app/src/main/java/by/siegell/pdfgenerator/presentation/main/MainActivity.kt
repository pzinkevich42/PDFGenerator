package by.siegell.pdfgenerator.presentation.main

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.siegell.pdfgenerator.R
import by.siegell.pdfgenerator.databinding.ActivityMainBinding
import by.siegell.pdfgenerator.presentation.LoanAgreementData
import by.siegell.pdfgenerator.presentation.detail.DocumentDetailFragment

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

        onBackPressedDispatcher.addCallback {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, DocumentListFragment.newInstance())
            .commit()
    }

    private fun openDetailFragment(loanAgreementData: LoanAgreementData) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, DocumentDetailFragment.newInstance(loanAgreementData))
            .addToBackStack(DocumentDetailFragment.TAG)
            .commit()
    }
}