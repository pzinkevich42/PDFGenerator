package by.siegell.pdfgenerator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val DOCUMENT_DATA = "DOCUMENT_DATA"

class DetailActivity : AppCompatActivity() {

    private lateinit var detailsData: LoanAgreementData

    private lateinit var numberView: TextView
    private lateinit var dateRuView: TextView
    private lateinit var dateEnView: TextView
    private lateinit var generateButtonView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getSerializableExtra(DOCUMENT_DATA) as? LoanAgreementData
        data?.let { detailsData = it } ?: finish()

        numberView = findViewById(R.id.number)
        dateRuView = findViewById(R.id.date_ru)
        dateEnView = findViewById(R.id.date_en)
        generateButtonView = findViewById(R.id.generate)

        with(detailsData) {
            numberView.text = "Number: $number"
            dateRuView.text = dateRu
            dateEnView.text = dateEn
        }

        generateButtonView.setOnClickListener {
            Toast.makeText(this, "Generate!", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

        fun createIntent(context: Context, loanAgreementData: LoanAgreementData): Intent {
            return Intent(
                context,
                DetailActivity::class.java
            ).putExtra(DOCUMENT_DATA, loanAgreementData)
        }
    }
}