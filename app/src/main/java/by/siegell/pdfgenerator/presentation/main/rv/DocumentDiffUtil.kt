package by.siegell.pdfgenerator.presentation.main.rv

import androidx.recyclerview.widget.DiffUtil
import by.siegell.pdfgenerator.presentation.LoanAgreementData

val LoanAgreementDiffCallback =
    object : DiffUtil.ItemCallback<LoanAgreementData>() {
        override fun areItemsTheSame(
            oldItem: LoanAgreementData,
            newItem: LoanAgreementData
        ) = oldItem.number == newItem.number

        override fun areContentsTheSame(
            oldItem: LoanAgreementData,
            newItem: LoanAgreementData
        ) = oldItem == newItem

    }