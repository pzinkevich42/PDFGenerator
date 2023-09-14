package by.siegell.pdfgenerator.domain

import by.siegell.pdfgenerator.domain.entity.DocumentEntity

class DocumentInteractor(
    private val repository: DocumentRepository
) {

    fun getDocumentData(): List<DocumentEntity> {
        return repository.getDocumentEntity()
    }
}

interface DocumentRepository {

    fun getDocumentEntity(): List<DocumentEntity>
}