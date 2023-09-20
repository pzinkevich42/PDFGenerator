package by.siegell.pdfgenerator.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.siegell.pdfgenerator.presentation.LoanAgreementData

class MainActivityViewModel : ViewModel() {

    private val _openDocumentEvent = MutableLiveData<LoanAgreementData>()
    val openDocumentEvent: LiveData<LoanAgreementData> = _openDocumentEvent

    fun openDocument(data: LoanAgreementData) {
        _openDocumentEvent.postValue(data)
    }
}