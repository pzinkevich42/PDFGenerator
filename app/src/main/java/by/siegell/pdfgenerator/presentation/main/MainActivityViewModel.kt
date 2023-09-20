package by.siegell.pdfgenerator.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.siegell.pdfgenerator.di.ManualDIFactory
import by.siegell.pdfgenerator.presentation.DocumentTypePresentationData
import by.siegell.pdfgenerator.presentation.PresentationMapper

class MainActivityViewModel: ViewModel() {

    private val interactor = ManualDIFactory.createInteractor()
    private val mapper = PresentationMapper()

    private val _documentList = MutableLiveData<List<DocumentTypePresentationData>>(emptyList())
    val documentList: LiveData<List<DocumentTypePresentationData>> = _documentList

    fun loadDocumentList() {
        _documentList.postValue(
            interactor.getDocumentData().map {
                mapper.toDocumentTypePresentationData(it)
            }
        )
    }
}