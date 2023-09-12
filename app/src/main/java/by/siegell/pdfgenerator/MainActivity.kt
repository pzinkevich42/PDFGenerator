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

        binding.loanAgreementButton.setOnClickListener {
            openDetailActivity(
                testDataFactory.getTestLoanAgreementData()
            )
        }
    }

    private fun openDetailActivity(loanAgreementData: LoanAgreementData) {
        startActivity(
            DetailActivity.createIntent(this, loanAgreementData)
        )
    }
}