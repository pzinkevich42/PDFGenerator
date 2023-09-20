package by.siegell.pdfgenerator.presentation

import androidx.recyclerview.widget.DiffUtil
import by.siegell.pdfgenerator.domain.entity.DocumentTypeData

data class DocumentTypePresentationData(
    val typeName: String,
    val payload: DocumentTypeData
)

val DocumentTypePresentationDataDiffCallback =
    object : DiffUtil.ItemCallback<DocumentTypePresentationData>() {
        override fun areItemsTheSame(
            oldItem: DocumentTypePresentationData,
            newItem: DocumentTypePresentationData
        ) = oldItem.typeName == newItem.typeName

        override fun areContentsTheSame(
            oldItem: DocumentTypePresentationData,
            newItem: DocumentTypePresentationData
        ) = oldItem == newItem

    }