package by.siegell.pdfgenerator.presentation

import java.io.Serializable

data class LoanAgreementData(
    val number: Int,
    val dateRu: String,
    val dateEn: String,
    val sumRu: String,
    val sumEn: String,
    val termRu: String,
    val termEn: String,
    val provideRu: String,
    val provideEn: String
) : Serializable