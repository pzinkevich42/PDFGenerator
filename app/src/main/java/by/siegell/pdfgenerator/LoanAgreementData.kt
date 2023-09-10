package by.siegell.pdfgenerator

import java.io.Serializable

class LoanAgreementData(
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