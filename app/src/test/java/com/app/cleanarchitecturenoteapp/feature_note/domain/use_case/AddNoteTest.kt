package com.app.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.app.cleanarchitecturenoteapp.feature_note.data.repository.FakeNoteRepository
import com.app.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.app.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddNoteTest {

    private lateinit var addNote: AddNote
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        addNote = AddNote(fakeNoteRepository)
    }

    @Test
    fun `note is inserted successfully without exception`() = runBlocking {
        val note = Note(
            title = "abc",
            content = "xyz",
            timestamp = System.currentTimeMillis(),
            color = 0
        )
        try {
            addNote(note)
            assert(true)
        } catch (e: InvalidNoteException) {
            assert(false)
        }
    }
}