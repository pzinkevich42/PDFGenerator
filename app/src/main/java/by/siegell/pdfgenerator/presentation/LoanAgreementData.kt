package by.siegell.pdfgenerator.presentation

import by.siegell.pdfgenerator.domain.entity.DocumentTypeData
import by.siegell.pdfgenerator.domain.entity.Type
import java.io.Serializable

data class LoanAgreementData(
    override val type: Type,
    val number: Int,
    val dateRu: String,
    val dateEn: String,
    val sumRu: String,
    val sumEn: String,
    val termRu: String,
    val termEn: String,
    val provideRu: String,
    val provideEn: String
) : Serializable, DocumentTypeData