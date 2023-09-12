package by.siegell.pdfgenerator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.siegell.pdfgenerator.databinding.ActivityDetailBinding

private const val DOCUMENT_DATA = "DOCUMENT_DATA"

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private lateinit var detailsData: LoanAgreementData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (intent.getSerializableExtra(DOCUMENT_DATA) as? LoanAgreementData)
            ?.let { detailsData = it } ?: finish()

        with(binding) {
            dateRu.text = detailsData.dateRu
            dateEn.text = detailsData.dateEn
        }

        binding.generate.setOnClickListener {
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