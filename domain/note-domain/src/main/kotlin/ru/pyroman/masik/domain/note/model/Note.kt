package ru.pyroman.masik.domain.note.model

import java.time.LocalDateTime

data class Note(
    val id: String,
    val body: NoteBody,
    val dateCreated: LocalDateTime,
)