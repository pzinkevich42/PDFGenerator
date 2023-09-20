package by.siegell.pdfgenerator.domain.entity

enum class Type {
    LOAN_AGREEMENT
}

interface DocumentTypeData {
    val type: Type
}

data class DocumentEntity(
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
) : DocumentTypeData
