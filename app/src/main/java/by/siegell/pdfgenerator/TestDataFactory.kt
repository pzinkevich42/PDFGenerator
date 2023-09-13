package by.siegell.pdfgenerator

class TestDataFactory {

    fun getTestDocumentTypes(): List<DocumentTypePresentationData> {
        return listOf(
            DocumentTypePresentationData(
                typeName = "Loan Agreement",
                payload = getTestLoanAgreementData()
            )
        )
    }

    fun getTestLoanAgreementData(): LoanAgreementData {
        return LoanAgreementData(
            type = Type.LOAN_AGREEMENT,
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
    }
}