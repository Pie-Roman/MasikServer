package ru.pyroman.masik.data.note.network.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class NoteNetworkDto(
    val id: String? = null,
    val body: NoteBodyNetworkDto? = null,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val dateCreated: LocalDateTime? = null,
)