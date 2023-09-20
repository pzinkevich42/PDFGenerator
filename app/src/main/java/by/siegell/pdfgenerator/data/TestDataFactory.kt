package by.siegell.pdfgenerator.data

import by.siegell.pdfgenerator.domain.DocumentRepository
import by.siegell.pdfgenerator.domain.entity.DocumentEntity

class TestDataFactory : DocumentRepository {

    override fun getDocumentEntity(): List<DocumentEntity> {
        return listOf(
            DocumentEntity(
                number = 5,
                dateRu = "12.04.5678",
                dateEn = "<<12>>th April 5678",
                sumRu = "12",
                sumEn = "12",
                termRu = "12",
                termEn = "12",
                provideRu = "12",
                provideEn = "12"
            )
        )
    }
}