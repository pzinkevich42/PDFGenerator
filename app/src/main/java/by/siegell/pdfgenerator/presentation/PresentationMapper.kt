package by.siegell.pdfgenerator.presentation

import by.siegell.pdfgenerator.domain.entity.DocumentEntity

class PresentationMapper {

    fun toDocumentTypePresentationData(entity: DocumentEntity): LoanAgreementData {
        return with(entity) {
            LoanAgreementData(
                number = number,
                dateRu = dateRu,
                dateEn = dateEn,
                sumRu = sumRu,
                sumEn = sumEn,
                termRu = termRu,
                termEn = termEn,
                provideRu = provideRu,
                provideEn = provideEn
            )
        }
    }
}