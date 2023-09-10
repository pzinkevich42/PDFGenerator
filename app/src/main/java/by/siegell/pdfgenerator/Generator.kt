package by.siegell.pdfgenerator

import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.Font
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream

class Generator {

    fun generate(loanAgreementData: LoanAgreementData) {
        val document = Document()
        PdfWriter.getInstance(document, FileOutputStream("${loanAgreementData.number}_Loan_agreement.pdf"))
        document.open()

        val regularFont = Font(
            BaseFont.createFont("TimesNewRomanRegular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED),
            12f
        )
        val boldFont = Font(
            BaseFont.createFont("TimesNewRomanBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED),
            12f
        )


        val table = PdfPTable(2)
        table.isSplitLate = false
        table.widthPercentage = 95f

        addTableHeader(loanAgreementData, table, regularFont, boldFont)
        addTableBaseRows(loanAgreementData, table, regularFont, boldFont)
        addAdditionalInfo(loanAgreementData, table, regularFont, boldFont)
        addSignature(table)

        document.add(table)
        document.close()
    }

    fun addTableHeader(loanAgreementData: LoanAgreementData, table: PdfPTable, regularFont: Font, boldFont: Font) {
        val headerRuCell = PdfPCell(
            Phrase(
                "ДОГОВОР ЗАЙМА № ${loanAgreementData.number}\n" +
                        "\n" +
                        "${loanAgreementData.dateRu}                      г. Минск", boldFont
            )
        )
        headerRuCell.horizontalAlignment = Element.ALIGN_CENTER
        table.addCell(headerRuCell)
        val headerEnCell = PdfPCell(
            Phrase(
                "LOAN AGREEMENT No ${loanAgreementData.number}\n" +
                        "\n" +
                        "${loanAgreementData.dateEn}                      Minsk", boldFont
            )
        )
        headerEnCell.horizontalAlignment = Element.ALIGN_CENTER
        table.addCell(headerEnCell)
    }

    fun addTableBaseRows(loanAgreementData: LoanAgreementData, table: PdfPTable, regularFont: Font, boldFont: Font) {
        table.addCell(
            Phrase("        Лупа Батькович", boldFont),
            Phrase(
                ", гражданин Соединенного Королевства Великобритании и Северной Ирландии, именуемый далее «Займодавец», с одной стороны, и \n",
                regularFont
            ),
            Phrase("        ООО «Байо Йайо»", boldFont),
            Phrase(
                ",  именуемое далее «Заемщик» в лице директора Пупы Батьковича, действующего на основании Устава, с другой стороны, заключили настоящий договор займа (далее-Договор) о нижеследующем:\n" +
                        "        1. Заимодавец предоставляет Заемщику заем на следующих условиях:\n" +
                        "        1.1. Сумма займа – ${loanAgreementData.sumRu};\n" +
                        "        1.2. Срок, на который выдается заем - до ${loanAgreementData.provideRu} года; досрочный возврат займа, а также возврат займа частями, допускается;\n" +
                        "        1.3. Процентная ставка за пользование заемными средствами – 6 % годовых. Если уровень инфляции в Республики Беларусь выше, чем указанная процентная ставка, процентная ставка за пользование заемными средствами по настоящему договору изменяется соответственно и приравнивается к уровню инфляции. При этом заключение дополнительного соглашения при таком изменении не требуется. Стороны признают такие изменения процентной ставки по настоящему договору займа. \n" +
                        "        1.4. Проценты по договору займа должны быть начислены и выплачены вместе с возвратом всей суммы займа (либо с последней частью займа, в случае возврата частями). При расчете процентов принимается календарное количество дней в месяце и в году. Начисление процентов осуществляется за период с даты поступления займа (части займа) на счет Заемщика до даты перечисления денежных средств в счет погашения займа (части займа).\n" +
                        "        2. Заимодавец предоставляет Заемщику сумму займа, указанную в п. 1.1. настоящего договора до ${loanAgreementData.provideRu} г. путем зачисления денежных средств на банковский счет Заемщика либо путем внесения в кассу организации Заемщика. Предоставление суммы займа частями допускается.\n" +
                        "        3. Заемщик обязуется возвратить полученный заем и проценты в сроки, установленные настоящим Договорам.\n" +
                        "        4. Возврат суммы займа и процентов производится на банковский счет Заимодавца либо в наличном порядке, либо любым иным способом, не запрещенным законодательством Республики Беларусь. Заем считается возвращенным с момента поступления суммы займа на банковский счет Заимодавца, дата передачи денежных средств Заимодавцу. Банковские расходы по возврату займа и уплате процентов несет Заемщик. \n" +
                        "        5. Заемщик имеет право в любой момент досрочно погасить заем и проценты за фактическое пользование суммой займа по настоящему Договору.\n" +
                        "        6. Настоящий договор регулируется действующим законодательством Республики Беларусь. Стороны примут все меры для того, чтобы решать разногласия и споры, которые могут возникнуть при исполнении обязательств по настоящему Договору, путем переговоров.\n" +
                        "        7. В случае невозможности урегулирования возникших между Сторонами разногласий путем переговоров, спорные дела подлежат разрешению в экономическом суде.\n" +
                        "        8. Все изменения и дополнения к настоящему Договору действительны лишь в том случае, если они совершены в письменной форме и подписаны уполномоченными лицами.\n" +
                        "        9. Если одна из Сторон изменит свое местонахождение, почтовые или банковские реквизиты, то она обязана немедленно проинформировать об этом другую Сторону.\n" +
                        "       10. Настоящий Договор заключен в двух экземплярах на английском и русском языках, один экземпляр хранится у Заимодавца, а другой – у Заемщика.\n" +
                        "       11. При наличии противоречий между английской и русской версиями настоящего Договора, приоритет при толковании имеет версия на русском языке.  \n",
                regularFont
            )
        )
        table.addCell(
            Phrase("          Lupa Batskovitch", boldFont),
            Phrase(
                ", a citizen of the United Kingdom of Great Britain and Northern Ireland (hereinafter referred to as the Lender) and\n",
                regularFont
            ),
            Phrase("        BAJO JAJO LLC", boldFont),
            Phrase(
                " represented by the director Pupa Batskovich acting on the basis of the Statute, (hereinafter referred to as the Borrower), on the other hand, concluded this loan agreement as follows:\n" +
                        "        1. The Lender provides the Borrower with a loan on the following terms:\n" +
                        "        1.1. Loan amount – ${loanAgreementData.sumEn};\n" +
                        "        1.2. The term for the loan – until ${loanAgreementData.termEn}. Early repayment of the loan as well as repayment of the loan in installments is allowed;\n" +
                        "        1.3. The interest rate for the use of borrowed funds – 6 % per annum. If the inflation rate in the Republic of Belarus is higher than the specified interest rate, the interest rate for the use of borrowed funds under this agreement should be changed accordingly and should be equal to the inflation rate. At the same time, the conclusion of an additional agreement with such a change is not required. The Parties recognize such changes in the interest rate under this loan agreement.\n" +
                        "        1.4. The interest under the loan agreement should be accrued and paid at the same time as a repayment of the loan (or with a last part of the loan in case of repayment of the loan in installments). A calendar number of days in a month and in a year is taken for calculating interest. Interest is accrued for the period since the date of receipt of the loan (part of the loan) to the Borrower’s account till the date of transfer of funds towards repayment of the loan (part of the loan);\n" +
                        "        2. The Lender provides the Borrower with the loan amount specified in clause 1.1. of this Agreement until ${loanAgreementData.provideEn} by crediting funds to the Bank account of the Borrower or by depositing them into the cashier of the Borrower's organization. Granting the loan amount in installments is allowed.\n" +
                        "        3. The Borrower undertakes to repay the loan and interest received within the terms established by these Agreements.\n" +
                        "        4. Refunds of the loan amount and interest are made to the Lender's bank account either in cash or in any other way not prohibited by the legislation of the Republic of Belarus. The loan is considered to be returned from the moment of receipt of the loan amount to the bank account of the Lender or the date of transfer of funds to the Lender. Banking expenses for loan repayment and interest payments shall be borne by the Borrower.\n" +
                        "        5. The Borrower has the right for the early repay of the loan and interest for the actual use of the loan amount under this Agreement.\n" +
                        "        6. The agreement is governed by the current legislation of the Republic of Belarus. The Parties of the Agreement will take all measures in order to resolve differences and disputes that may arise in the performance of obligations under this Agreement through negotiations.\n" +
                        "        7. If it is impossible to settle the disagreements that have arisen between the Parties through negotiations the disputed cases are subject to resolution in the economic court.\n" +
                        "        8. All changes and additions to this Agreement are valid only if they are made in writing and signed by authorized persons.\n" +
                        "        9. If one of the Parties changes its location, postal or bank details, it is obliged to immediately inform the other Party about it.\n" +
                        "       10. This loan Agreement is made in duplicate in English and Russian, one copy is kept by the Lender and the other – by the Borrower.\n" +
                        "       11. If there are contradictions between the English and Russian versions of this Agreement the interpretation in Russian shall prevail.",
                regularFont
            )
        )
    }

    fun addAdditionalInfo(loanAgreementData: LoanAgreementData, table: PdfPTable, regularFont: Font, boldFont: Font) {
        table.addCell(
            Phrase("Заемщик\n", boldFont),
            Phrase(
                "ООО \"Байо Йайо\"\n" +
                        "юр.адрес: Республика Беларусь, 220099, г. Минск, пр-т Крутой, д. 432. пом.8\n" +
                        "УНП 123456789\n" +
                        "р/с BY00 ABCD 0000 0000 0000 0000 0000 в ООО \"БАНК\"\n" +
                        "БИК: NICEBANK\n", regularFont
            )
        )
        table.addCell(
            Phrase("Заимодавец\n", boldFont),
            Phrase(
                "Лупа Батькович\n" +
                        "Паспорт: №123456789\n" +
                        "Выдан: Паспортным столом Её Величества\n" +
                        "Дата выдачи: 05.07.2016 г\n", regularFont
            )
        )
        table.addCell(
            Phrase("Borrower\n", boldFont),
            Phrase(
                "BAJO JAJO LLC\n" +
                        "Legal address: 220099, Minsk, Cool avenue, 432 – 8\n" +
                        "Registration N 123456789\n" +
                        "Bank account BY00 ABCD 0000 0000 0000 0000 0000 \n" +
                        "SWIFT: NICEBANK\n", regularFont
            )
        )
        table.addCell(
            Phrase("Lender\n", boldFont),
            Phrase(
                "Lupa Batskovich\n" +
                        "Passport 123456789\n" +
                        "Issued by the HM Passport Office\n" +
                        "The date of issue – 05th May 2016\n", regularFont
            )
        )
    }

    fun addSignature(table: PdfPTable) {
        table.addCell(
            "\n" +
                    "\n" +
                    "____________________/" +
                    "\n" +
                    "\n" +
                    "\n"
        )
        table.addCell(
            "\n" +
                    "\n" +
                    "____________________/" +
                    "\n" +
                    "\n" +
                    "\n"
        )
    }

    private fun Phrase.addElement(element: Element): Phrase = add(element).let { this }

    private fun List<Phrase>.combine(): Phrase = reduce { new, acc -> acc.addElement(new) }

    private fun PdfPTable.addCell(vararg phrases: Phrase) {
        addCell(phrases.toList().reversed().combine())
    }
}