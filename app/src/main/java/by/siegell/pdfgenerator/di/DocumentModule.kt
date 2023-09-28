package by.siegell.pdfgenerator.di

import by.siegell.pdfgenerator.data.TestDataFactory
import by.siegell.pdfgenerator.domain.DocumentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DocumentModule {

    @Binds
    abstract fun bindRepository(testDataFactory: TestDataFactory): DocumentRepository
}