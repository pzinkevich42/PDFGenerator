package by.siegell.pdfgenerator.di

import by.siegell.pdfgenerator.data.TestDataFactory
import by.siegell.pdfgenerator.domain.DocumentInteractor

object ManualDIFactory {

    fun createInteractor() = DocumentInteractor(TestDataFactory())
}