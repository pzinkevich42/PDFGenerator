package by.siegell.pdfgenerator.presentation

import by.siegell.pdfgenerator.domain.entity.DocumentEntity

class PresentationMapper {

    fun toDocumentTypePresentationData(entity: DocumentEntity): DocumentTypePresentationData {
        return DocumentTypePresentationData(
            "Loan Agreement",
            entity
        )
    }
}