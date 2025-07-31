package ru.pyroman.masik.domain.note.model

data class NoteBody(
    val title: String,
    val isDone: Boolean,
    val tags: Set<NoteTag>,
)