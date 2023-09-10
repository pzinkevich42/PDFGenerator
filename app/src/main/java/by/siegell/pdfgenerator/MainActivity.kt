package by.siegell.pdfgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var loanAgreementButton: Button
    private val testDataFactory = TestDataFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loanAgreementButton = findViewById(R.id.loan_agreement_button)
        loanAgreementButton.setOnClickListener {
            openDetailActivity(
                testDataFactory.getTestLoanAgreementData()
            )
        }
    }

    fun openDetailActivity(loanAgreementData: LoanAgreementData) {
        startActivity(
            DetailActivity.createIntent(this, loanAgreementData)
        )
    }
}