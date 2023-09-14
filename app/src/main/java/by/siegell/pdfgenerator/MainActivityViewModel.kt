package by.siegell.pdfgenerator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val dataFactory = TestDataFactory()

    private val _documentList = MutableLiveData<List<DocumentTypePresentationData>>(emptyList())
    val documentList: LiveData<List<DocumentTypePresentationData>> = _documentList

    fun loadDocumentList() {
        _documentList.postValue(dataFactory.getTestDocumentTypes())
    }
}