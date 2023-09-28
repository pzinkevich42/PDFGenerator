package by.siegell.pdfgenerator.domain

import by.siegell.pdfgenerator.domain.entity.DocumentEntity
import javax.inject.Inject

class DocumentInteractor
@Inject constructor(
    private val repository: DocumentRepository
) {

    fun getDocumentData(): List<DocumentEntity> {
        return repository.getDocumentEntity()
    }
}

interface DocumentRepository {

    fun getDocumentEntity(): List<DocumentEntity>
}